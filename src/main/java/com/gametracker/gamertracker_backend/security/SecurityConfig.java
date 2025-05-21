package com.gametracker.gamertracker_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactiva CSRF (necesario si usas Postman o no tienes frontend aún)
                // CSRF es un mecanismo de seguridad para prevenir ataques CSRF. (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable())

                // Permite TO,DO (rutas públicas sin autenticación)
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())

                // Activamos autenticación básica por si quisieras probar login básico más adelante
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
