package com.cdac.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cdac.rest.security.MyUserDetailsService;

@Configuration

public class AppSecurityConfigurer {
	
	
	
	
	@Bean
	AuthTokenFilter authTokenFilter() {
		return new AuthTokenFilter();
	};
	/*@Autowired
	AuthTokenFilter authTokenFilter;*/
	
	
	
	@Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/user").hasAuthority("USER")
		.antMatchers("/admin").hasAuthority("ADMIN")
		.and()
		.formLogin(); */
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(authorize -> {
			authorize.requestMatchers("/all").permitAll();
			authorize.requestMatchers("/signin").permitAll();
			authorize.requestMatchers("/signup").permitAll();			
			authorize.requestMatchers("/c").hasAuthority("USER");
			authorize.requestMatchers("/admin").hasAnyAuthority("ADMIN","USER");
			authorize.requestMatchers("/registerDoctor").permitAll();
			authorize.requestMatchers("/verifyLogin").permitAll();
			authorize.requestMatchers("/Login").permitAll();

		})
		.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
    }
	
	@Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider  = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
	
	@Bean
    UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }
	
	/*protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
		
	}*/
	
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

}
