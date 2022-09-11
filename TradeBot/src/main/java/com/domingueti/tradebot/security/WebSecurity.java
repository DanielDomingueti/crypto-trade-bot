package com.domingueti.tradebot.security;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.domingueti.tradebot.modules.User.repositories.UserRouteRepository;
import com.domingueti.tradebot.security.exceptions.AuthenticationExceptionHandler;
import com.domingueti.tradebot.security.filters.AdminAuthenticationFilter;
import com.domingueti.tradebot.security.filters.AdminAuthorizationFilter;
import com.domingueti.tradebot.security.filters.UserAuthenticationFilter;
import com.domingueti.tradebot.security.filters.UserAuthorizationFilter;
import com.domingueti.tradebot.security.jwt.SecurityConstants;
import com.domingueti.tradebot.security.services.AdminDetailsServiceImpl;
import com.domingueti.tradebot.security.services.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableWebSecurity
public class WebSecurity {

	private UserDetailsServiceImpl userDetailsService;
	private AdminDetailsServiceImpl adminDetailsServiceImpl;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private SecurityConstants securityConstants;
	private ConfigService configService;
	
	private UserRouteRepository userRouteRepository;
	private AdminRouteRepository adminRouteRepository;
	
	@Configuration
	@Order(1)
	public class WebSecurityFirstEndpoint extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();

			http.cors();

			// AWS Health
			http.requestMatchers().antMatchers(HttpMethod.GET, securityConstants.getHealthUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.GET, securityConstants.getHealthUrl()).permitAll();

			// D4Sign Webhook
			http.requestMatchers().antMatchers(HttpMethod.POST, configService.getD4SignWebHookUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, configService.getD4SignWebHookUrl()).permitAll();

			// Login de usuário
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl())
				.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl()).permitAll();

			// Login de usuário como admin
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getPortalAdminLoginUrl())
					.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getPortalAdminLoginUrl()).permitAll();
			
			// Esqueceu senha
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getUserForgotPassUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getUserForgotPassUrl())
					.permitAll();

			// Recuperar senha
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getUserResetPassUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getUserResetPassUrl())
					.permitAll();

			UserAuthenticationFilter authenticationFilter = new UserAuthenticationFilter(authenticationManager());
			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInUserUrl());

			List<UserRouteDTO> routes = userRouteRepository.findAllByDeletedAtIsNull();

			for (UserRouteDTO eachRoute : routes) {

				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
						.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).authenticated()
						.and().addFilter(new UserAuthorizationFilter(authenticationManager()));
			}

			http.requestMatchers().antMatchers(securityConstants.getSignInUserUrl()).and()
					.addFilter(authenticationFilter);

			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}

	}

	@Configuration
	@Order(2)
	public class WebSecuritySecondEndpoint extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();

			http.cors();

			// Cron Rendimentos
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getCronIncomesUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getCronIncomesUrl())
					.permitAll();

			// Cron Balances
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getCronBalancesUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getCronBalancesUrl())
					.permitAll();

			// Cron Sidebar
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getCronSidebarUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getCronSidebarUrl())
					.permitAll();
			
			// Login de Administrador 2FA
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl2Fa()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl2Fa())
					.permitAll();

			// Login de Administrador
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl())
					.permitAll();

			// Esqueceu senha
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getAdminForgotPassUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getAdminForgotPassUrl())
					.permitAll();

			// Recuperar senha
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getAdminResetPassUrl()).and()
					.authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getAdminResetPassUrl())
					.permitAll();

			AdminAuthenticationFilter authenticationFilter = new AdminAuthenticationFilter(authenticationManager());
			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInAdminUrl());

			List<AdminRouteOnlyDataDTO> routes = adminRouteRepository.findAllByDeletedAtIsNull();

			for (AdminRouteOnlyDataDTO eachRoute : routes) {

				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
						.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).authenticated()
						.and().addFilter(new AdminAuthorizationFilter(authenticationManager()));
			}

			http.requestMatchers().antMatchers(securityConstants.getSignInAdminUrl()).and()
					.addFilter(authenticationFilter);

			http.requestMatchers().antMatchers("/**").and().authorizeRequests().anyRequest().authenticated();

			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(adminDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);

		}

	}
}