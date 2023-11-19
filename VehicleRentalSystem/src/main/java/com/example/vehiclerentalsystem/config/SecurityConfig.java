package com.example.vehiclerentalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.vehiclerentalsystem.filter.JwtAuthFilter;




@Configuration
@EnableWebSecurity 

public class SecurityConfig {
	
	@Autowired
	JwtAuthFilter authFilter;

    @Bean
 public UserDetailsService userDetailsService() {   //noraml spring security+JWT

        return  new UserRolesService();
    }

	/*
	 * @Bean SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
	 * throws Exception {
	 * 
	 * httpSecurity.formLogin(Customizer.withDefaults());
	 * httpSecurity.csrf().disable();
	 * httpSecurity.headers().frameOptions().disable(); httpSecurity
	 * .authorizeHttpRequests() .requestMatchers("/delete").hasAuthority("ADMIN")
	 * .requestMatchers("/h2-console/**").permitAll() .anyRequest().authenticated();
	 * return httpSecurity.build(); }
	 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {      //normal spring security+JWT
        return http.csrf().disable()               
                .authorizeHttpRequests()
                .requestMatchers("/api/vehicle/get/**","/api/jwtToken/**","/v3/api-docs/**", "/swagger-ui/**","/swagger-resources/**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/api/vehicle/add")
                .authenticated().and()//.formLogin().and().build();
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
               // .authenticationProvider(authenticationProvider())
               // .addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){   //normal spring security + JWT
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    

    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
}
