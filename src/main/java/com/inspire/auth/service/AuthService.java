package com.inspire.auth.service;

import com.inspire.auth.repository.UserRepository;
import com.inspire.auth.request.AuthRequest;
import com.inspire.auth.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public String loginUser(AuthRequest authRequest) throws BadCredentialsException {
        log.info("Attempting to login user with email: {}", authRequest.getEmail().toLowerCase());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail().toLowerCase(), authRequest.getPassword()));
        var user=userRepository.findByEmail(authRequest.getEmail().toLowerCase()).get();
        user.setLastLoginTime(new Date());
        userRepository.save(user);
        log.info("User logged in successfully: {}", user.getEmail());
        return jwtTokenUtil.createToken(user);
    }
}
