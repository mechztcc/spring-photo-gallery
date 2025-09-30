package com.example.photo_gallery.modules.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.auth.dto.AuthDTO;
import com.example.photo_gallery.modules.auth.dto.AuthResponseDTO;
import com.example.photo_gallery.modules.auth.services.CreateSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CreateSession createSession;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createSession.execute(payload));
    }

}
