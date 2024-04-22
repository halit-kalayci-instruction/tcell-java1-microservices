package com.turkcell.authservice.services.abstracts;

import com.turkcell.authservice.services.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterRequest request);
}
