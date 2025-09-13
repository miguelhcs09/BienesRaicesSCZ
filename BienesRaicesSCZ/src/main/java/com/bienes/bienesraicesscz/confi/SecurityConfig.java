package com.bienes.bienesraicesscz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        // Esta lista ya es la correcta y final
                        .requestMatchers(
                                "/api/auth/**",
                                "/api/catalogo/**",
                                "/login.html",
                                "/index.html",
                                "/catalogo.html",
                                "/detalle.html",
                                "/agentes.html",
                                "/images/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}