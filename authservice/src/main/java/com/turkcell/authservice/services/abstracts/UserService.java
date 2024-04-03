package com.turkcell.authservice.services.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register();
}
