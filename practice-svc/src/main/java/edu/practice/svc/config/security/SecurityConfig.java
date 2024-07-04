package edu.practice.svc.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher("/rest/**")
//                .authorizeHttpRequests(authorize -> authorize.anyRequest()
//                        .hasAnyAuthority("SCOPE_practice-svc.consult"))
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
//        return http.build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .authorizeHttpRequests(request -> request
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/rest/**")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/openapi")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/openapi/**")).permitAll()
                        .anyRequest().authenticated()
                ).build();
    }
}
