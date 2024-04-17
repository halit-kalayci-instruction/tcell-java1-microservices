package com.turkcell.authservice.core.configuration;

import com.halitkalayci.configuration.HttpSecurityCustomizer;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class SecurityCustomizer implements HttpSecurityCustomizer {
    private static final String[] WHITE_LIST_URLS = {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/v1/auth/**"
    };
    @Override
    public void customize(HttpSecurity httpSecurity) throws Exception {
        // TODO : Debug and solve.
        httpSecurity.authorizeHttpRequests(req -> req
                .requestMatchers(WHITE_LIST_URLS).permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/test/**").hasAnyAuthority("admin")
                .anyRequest().authenticated()
        );
    }
}
