package com.example.photo_gallery.modules.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.auth.dto.AuthDTO;
import com.example.photo_gallery.modules.auth.dto.AuthResponseDTO;
import com.example.photo_gallery.modules.users.model.User;
import com.example.photo_gallery.modules.users.repositories.UsersRepository;
import com.example.photo_gallery.security.JwtService;

@Service
public class CreateSession {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    public AuthResponseDTO execute(AuthDTO payload) {
        User user = usersRepository.findByEmail(payload.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(payload.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponseDTO(token, user.getEmail(), user.getName());
    }

}
