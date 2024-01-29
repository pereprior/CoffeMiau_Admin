package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails clientTest = User.builder()
                .username("client")
                .password("{noop}client")
                .roles("CLIENTE")
                .build();

        UserDetails employeeTest = User.builder()
                .username("employee")
                .password("{noop}employee")
                .roles("EMPLEADO")
                .build();

        UserDetails adminTest = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("EMPLEADO","ADMINISTRADOR")
                .build();

        return new InMemoryUserDetailsManager(clientTest, employeeTest, adminTest);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(
                LogoutConfigurer::permitAll
        ).exceptionHandling(configurer ->
                configurer.accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}