package com.example.photo_gallery.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.user.dto.UserDTO;
import com.example.photo_gallery.modules.user.model.User;
import com.example.photo_gallery.modules.user.repositories.UsersRepository;

@Service
public class CreateUserService {

    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User execute(UserDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(user.toEntity());
    }
}
