package com.example.photo_gallery.modules.galleries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.galleries.dto.GalleryDTO;
import com.example.photo_gallery.modules.galleries.model.Gallery;
import com.example.photo_gallery.modules.galleries.repositories.GalleryRepository;
import com.example.photo_gallery.modules.users.model.User;
import com.example.photo_gallery.modules.users.repositories.UsersRepository;

@Service
public class CreateGalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private UsersRepository userRepository;

    public Gallery execute(GalleryDTO gallery) {

        User userExists = userRepository.findById(gallery.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + gallery.getOwnerId()));

        Gallery newGallery = gallery.toEntity();
        newGallery.setOwner(userExists);

        return galleryRepository.save(newGallery);
    }
}
