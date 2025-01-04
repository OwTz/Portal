package com.asyncsupport.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@SpringBootApplication
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Nova sintaxe para desativar CSRF (apenas para testes)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/users").permitAll()// Apenas usuários com papel USER acessam /home
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Apenas usuários com papel ADMIN acessam /admin
                        .anyRequest().authenticated() // Todas as outras rotas requerem autenticação
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll()); // Habilita o formulário de login padrão
        return http.build();

    }


}
