package com.example.movieproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class securityconfig {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .requestMatchers("/", "/home").permitAll()  // Allow access to these paths without authentication
                    .anyRequest().authenticated()              // All other requests need authentication
                    .and()
                    .formLogin(withDefaults());                 // Use default form login configuration

            return http.build();
        }
    }