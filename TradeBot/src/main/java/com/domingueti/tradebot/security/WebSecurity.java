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

import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteOnlyDataDTO;
import com.domingueti.tradebot.modules.Admin.repositories.AdminRouteRepository;
import com.domingueti.tradebot.modules.User.dtos.UserRouteDTO;
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

	private UserRouteRepository userRouteRepository;
	
	private AdminRouteRepository adminRouteRepository;
	
	private SecurityConstants securityConstants;
	
	private UserDetailsServiceImpl userDetailsService;
	
	private AdminDetailsServiceImpl adminDetailsService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Configuration
	@Order(1)
	public class WebSecurityFirstEndpoint extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			//Csrf is not necessary once the application is servless.
			http.csrf().disable();
			
			http.cors();
			
			//User Login
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl())
				.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl()).permitAll();

			UserAuthenticationFilter authenticationFilter = new UserAuthenticationFilter(authenticationManager());
			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInUserUrl());
			
			List<UserRouteDTO> userRoutes = userRouteRepository.findAllByDeletedAtIsNull();
			
			for (UserRouteDTO eachRoute : userRoutes) {
				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
					.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).authenticated()
					.and().addFilter(new UserAuthorizationFilter(authenticationManager()));

			}
			
			http.requestMatchers().antMatchers(securityConstants.getSignInUserUrl()).and()
				.addFilter(authenticationFilter);
			
			http.requestMatchers().antMatchers("/**").and().authorizeRequests().anyRequest().authenticated();
			
			//Ensure the backend won't create an user session.
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}

	}

	@Configuration
	@Order(2)
	public class WebSecuritySecondEndpoint extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			//Csrf is not necessary once the application is servless.
			http.csrf().disable();

			http.cors();
			
			//Admin Login
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl())
				.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl()).permitAll();
			
			AdminAuthenticationFilter authenticationFilter = new AdminAuthenticationFilter(authenticationManager());
			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInAdminUrl());
			
			List<AdminRouteOnlyDataDTO> adminRoutes = adminRouteRepository.findByDeletedAtIsNull();
			
			for (AdminRouteOnlyDataDTO eachRoute : adminRoutes) {
				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
					.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).authenticated()
					.and().addFilter(new AdminAuthorizationFilter(authenticationManager()));
			}
			
			http.requestMatchers().antMatchers(securityConstants.getSignInAdminUrl()).and()
			.addFilter(authenticationFilter);
		
			http.requestMatchers().antMatchers("/**").and().authorizeRequests().anyRequest().authenticated();
			
			//Ensure the backend won't create an user session.
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
		
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(adminDetailsService).passwordEncoder(bCryptPasswordEncoder);
		}
		
	}

}
