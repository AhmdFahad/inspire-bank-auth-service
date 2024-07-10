package com.inspire.auth.service;

import com.aqarati.auth.exception.RequestMissingInformation;
import com.inspire.auth.repository.UserRepository;
import com.inspire.auth.request.AuthRequest;
import com.inspire.auth.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    public String loginUser(AuthRequest authRequest) throws BadCredentialsException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail().toLowerCase(), authRequest.getPassword()));
        var user=userRepository.findByEmail(authRequest.getEmail().toLowerCase()).get();
        return jwtTokenUtil.createToken(user);
    }
}
