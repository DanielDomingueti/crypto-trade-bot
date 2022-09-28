package com.domingueti.tradebot.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.domingueti.tradebot.modules.Admin.dtos.AdminRouteDTO;
import com.domingueti.tradebot.modules.Admin.repositories.AdminRouteRepository;
import com.domingueti.tradebot.modules.User.dtos.UserRouteDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRouteRepository;
import com.domingueti.tradebot.security.jwt.SecurityConstants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableWebSecurity
public class WebSecurity {

	private UserRouteRepository userRouteRepository;
	
	private AdminRouteRepository adminRouteRepository;
	
	private SecurityConstants securityConstants;
	
	private UserDetailsService userDetailsService;
	
	@Configuration
	@Order(1)
	public class FirstSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			//Csrf is not necessary once the application is servless.
			http.cors().and().csrf().disable();
			
			//User Login
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl())
				.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInUserUrl()).permitAll();
			
//			UserAuthenticationFilter authenticationFilter = new UserAuthenticationFilter(authenticationManager());
//			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
//			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInUserUrl());
			
			List<UserRouteDTO> userRoutes = userRouteRepository.findAllByDeletedAtIsNull();
			
			for (UserRouteDTO eachRoute : userRoutes) {
				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
					.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).permitAll();
			}
			
//			http.requestMatchers().antMatchers(securityConstants.getSignInUserUrl()).and()
//				.addFilter(authenticationFilter);
			
			//Ensure the backend won't create an user session.
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		}

		//Give access to the app's endpoints from multiple sources based on basic configurations.
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
			return source;
		}
		
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
	}
	
	@Configuration
	@Order(2)
	public class SecondSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			//Csrf is not necessary once the application is servless.
			http.cors().and().csrf().disable();
			
			//Admin Login
			http.requestMatchers().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl())
				.and().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignInAdminUrl()).permitAll();
			
//			AdminAuthenticationFilter authenticationFilter = new AdminAuthenticationFilter(authenticationManager());
//			authenticationFilter.setAuthenticationFailureHandler(new AuthenticationExceptionHandler());
//			authenticationFilter.setFilterProcessesUrl(securityConstants.getSignInAdminUrl());
			
			List<AdminRouteDTO> adminRoutes = adminRouteRepository.findAllByDeletedAtIsNull();
			
			for (AdminRouteDTO eachRoute : adminRoutes) {
				http.requestMatchers().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).and()
					.authorizeRequests().antMatchers(eachRoute.getMethod(), eachRoute.getRoute()).permitAll();
			}
			
//			http.requestMatchers().antMatchers(securityConstants.getSignInAdminUrl()).and()
//				.addFilter(authenticationFilter);
			
			http.requestMatchers().antMatchers("/**").and().authorizeRequests().anyRequest().authenticated();
			
			//Ensure the backend won't create an user session.
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
		
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		}
		
		//Give access to the app's endpoints from multiple sources based on basic configurations.
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
			return source;
		}
		
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
	}
	
}
