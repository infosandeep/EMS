package com.sandeep.emsservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService () {
		
		InMemoryUserDetailsManager ud = new InMemoryUserDetailsManager();

		
		UserDetails user = User.withUsername("sandeep").password("sandeep").authorities("read").build();
		
		ud.createUser(user);
		return ud;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder () {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	

}
