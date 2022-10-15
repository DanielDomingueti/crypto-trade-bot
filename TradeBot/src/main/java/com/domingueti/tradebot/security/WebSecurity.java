package com.domingueti.tradebot.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.domingueti.tradebot.modules.User.dtos.UserRouteDTO;
import com.domingueti.tradebot.modules.User.repositories.UserRouteRepository;
import com.domingueti.tradebot.security.exceptions.AuthenticationExceptionHandler;
import com.domingueti.tradebot.security.filters.UserAuthenticationFilter;
import com.domingueti.tradebot.security.filters.UserAuthorizationFilter;
import com.domingueti.tradebot.security.jwt.SecurityConstants;
import com.domingueti.tradebot.security.services.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableWebSecurity
public class WebSecurity {

	private UserRouteRepository userRouteRepository;
	
	private SecurityConstants securityConstants;
	
	private UserDetailsServiceImpl userDetailsService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Configuration
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
			
			List<UserRouteDTO> allUserRoutes = userRouteRepository.findAllByDeletedAtIsNull();
			List<UserRouteDTO> userRoutes = new ArrayList<>();
			List<UserRouteDTO> adminRoutes = new ArrayList<>();
			
			for (UserRouteDTO eachRoute : allUserRoutes) {
				System.out.println(eachRoute.getRoute());

				if (eachRoute.getRoute().startsWith("/admin")) {
					adminRoutes.add(eachRoute);
				} else {
					userRoutes.add(eachRoute);
				}
			}
			
			for (UserRouteDTO adminRoute : adminRoutes) {
				http.requestMatchers().antMatchers(adminRoute.getMethod(), adminRoute.getRoute()).and()
					.authorizeRequests().antMatchers(adminRoute.getMethod(), adminRoute.getRoute()).authenticated()
					.and().addFilter(new UserAuthorizationFilter(authenticationManager()));
			}
			
			for (UserRouteDTO userRoute : userRoutes) {
				http.requestMatchers().antMatchers(userRoute.getMethod(), userRoute.getRoute()).and()
					.authorizeRequests().antMatchers(userRoute.getMethod(), userRoute.getRoute()).authenticated()
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

}
