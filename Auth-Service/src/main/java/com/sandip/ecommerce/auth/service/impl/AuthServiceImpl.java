package com.sandip.ecommerce.auth.service.impl;

import com.sandip.ecommerce.auth.dto.JwtResponse;
import com.sandip.ecommerce.auth.dto.LoginRequest;
import com.sandip.ecommerce.auth.dto.RegisterRequest;
import com.sandip.ecommerce.auth.entity.Role;
import com.sandip.ecommerce.auth.entity.RoleName;
import com.sandip.ecommerce.auth.entity.User;
import com.sandip.ecommerce.auth.exception.UserAlreadyExistsException;
import com.sandip.ecommerce.auth.repository.RoleRepository;
import com.sandip.ecommerce.auth.repository.UserRepository;
import com.sandip.ecommerce.auth.security.JwtTokenProvider;
import com.sandip.ecommerce.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(userRole))
                .build();

        userRepository.save(user);

        return "User registered successfully";
    }

    @Override
    public JwtResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsernameOrEmail(),
                                request.getPassword()));

        String token = jwtTokenProvider.generateToken(authentication);

        return JwtResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }

}