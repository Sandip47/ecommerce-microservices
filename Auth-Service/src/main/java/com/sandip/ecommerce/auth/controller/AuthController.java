package com.sandip.ecommerce.auth.controller;

import com.sandip.ecommerce.auth.dto.JwtResponse;
import com.sandip.ecommerce.auth.dto.LoginRequest;
import com.sandip.ecommerce.auth.dto.RegisterRequest;
import com.sandip.ecommerce.auth.service.AuthService;
import com.sandip.ecommerce.auth.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(
            @Valid @RequestBody RegisterRequest request) {

        String response = authService.register(request);

        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .success(true)
                        .message(response)
                        .data(response)
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<JwtResponse>> login(
            @Valid @RequestBody LoginRequest request) {

        JwtResponse jwtResponse = authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.<JwtResponse>builder()
                        .success(true)
                        .message("Login Successful")
                        .data(jwtResponse)
                        .build()
        );
    }
}