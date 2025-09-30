package com.example.photo_gallery.modules.galleries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.galleries.dto.CreateGalleryResponseDTO;
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

    public CreateGalleryResponseDTO execute(GalleryDTO gallery) {

        User userExists = userRepository.findById(gallery.getOwnerId()).orElse(null);
        if(userExists == null) {   
            throw new RuntimeException("User not found with id: " + gallery.getOwnerId());
        }

        Gallery newGallery = gallery.toEntity();
        newGallery.setOwner(userExists);

        Gallery data = galleryRepository.save(newGallery);

        return new CreateGalleryResponseDTO(
                data.getId(),
                data.getName(),
                data.getDescription(),
                data.getIsPublic(),
                data.getCreatedAt(),
                data.getUpdatedAt());
    }
}
