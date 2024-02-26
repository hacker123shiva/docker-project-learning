package com.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		// provider.setPasswordEncoder( new BCryptPasswordEncoder(12));
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

	// @Bean
	// public BCryptPasswordEncoder encodePassword()
	// {
	// return new BCryptPasswordEncoder();
	// }

	// @Bean
	// public UserDetailsService userDetailsSErvice() {
	// UserDetails user=User
	// .withDefaultPasswordEncoder()
	// .username("muskan")
	// .password("root")
	// .roles("USER")
	// .build();
	//
	// UserDetails user1=User
	// .withDefaultPasswordEncoder()
	// .username("admin")
	// .password("root")
	// .roles("ADMIN")
	// .build();
	// return new InMemoryUserDetailsManager(user,user1);
	// }
	//

}
