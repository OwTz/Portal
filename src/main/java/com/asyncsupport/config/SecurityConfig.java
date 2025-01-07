package com.asyncsupport.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@SpringBootApplication
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/scripts/home-page.js").permitAll()
                        .requestMatchers("/style.css").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Apenas usuários com papel ADMIN acessam /admin
                        .anyRequest().hasRole("ADMIN") // Todas as outras rotas requerem autenticação
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll()); // Habilita o formulário de login padrão
        return http.build();

    }


}
