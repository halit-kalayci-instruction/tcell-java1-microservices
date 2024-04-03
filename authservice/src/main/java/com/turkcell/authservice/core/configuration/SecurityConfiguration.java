package com.turkcell.authservice.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> req
                        //.requestMatchers("/swagger-ui/**").authenticated()
                        .anyRequest().permitAll()
                        );
                // .httpBasic(AbstractHttpConfigurer::disable); vs... zincirin diğer halkaları..
        return http.build();
    }
}
