package com.turkcell.authservice.services.concretes;

import com.turkcell.authservice.entities.User;
import com.turkcell.authservice.services.abstracts.AuthService;
import com.turkcell.authservice.services.abstracts.UserService;
import com.turkcell.authservice.services.dtos.requests.LoginRequest;
import com.turkcell.authservice.services.dtos.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private UserService userService;
    @Override
    public void register(RegisterRequest request) {
        // 9:15
        // TODO: Mapstruct
        userService.add(request);
    }

    @Override
    public void login(LoginRequest request) {
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
      System.out.println(authentication.isAuthenticated());
    }
}
