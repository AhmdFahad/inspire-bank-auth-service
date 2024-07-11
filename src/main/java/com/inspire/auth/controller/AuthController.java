package com.inspire.auth.controller;

import com.inspire.auth.request.AuthRequest;
import com.inspire.auth.response.AuthResponse;
import com.inspire.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personal/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> userLogin(@RequestBody AuthRequest authRequest) throws BadCredentialsException {
        var token=authService.loginUser(authRequest);
        var res=AuthResponse.builder().
                message("User login successful").
                token(token).
                tokenType("JWT bearer token").
                build();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
