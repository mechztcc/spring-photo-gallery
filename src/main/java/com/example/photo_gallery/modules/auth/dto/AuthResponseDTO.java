package com.example.photo_gallery.modules.auth.dto;

public class AuthResponseDTO {
    private String token;
    private String email;
    private String username;

    public AuthResponseDTO(String token, String email, String username) {
        this.token = token;
        this.email = email;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
