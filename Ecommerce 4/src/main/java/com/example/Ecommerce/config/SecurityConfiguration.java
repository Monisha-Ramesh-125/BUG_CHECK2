package com.example.Ecommerce.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests(authorize->
                        {
                            try{
                                authorize.requestMatchers("/api/v1/auth/**").permitAll()
                                        .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                                        .and()
                                        .sessionManagement()
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //so that each http is authenticated
                                        .and()
                                        .authenticationProvider(authenticationProvider)
                                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                                        .logout()
                                        .logoutUrl("/api/v1/auth/logout")
                                        .addLogoutHandler(logoutHandler)
                                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
                            }catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }

                );
        return http.build();
    }}

