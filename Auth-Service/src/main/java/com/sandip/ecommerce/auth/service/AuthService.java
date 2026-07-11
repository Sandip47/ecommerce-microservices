package com.sandip.ecommerce.auth.service;

import com.sandip.ecommerce.auth.dto.JwtResponse;
import com.sandip.ecommerce.auth.dto.LoginRequest;
import com.sandip.ecommerce.auth.dto.RegisterRequest;

public interface AuthService {

    JwtResponse login(LoginRequest request);

    String register(RegisterRequest request);

}