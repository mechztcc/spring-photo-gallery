package com.example.photo_gallery.modules.photos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.galleries.model.Gallery;
import com.example.photo_gallery.modules.galleries.repositories.GalleryRepository;
import com.example.photo_gallery.modules.photos.dto.UploadPhotoDTO;
import com.example.photo_gallery.modules.photos.dto.UploadPhotoResponseDTO;
import com.example.photo_gallery.modules.photos.model.Photo;
import com.example.photo_gallery.modules.photos.repositories.PhotosRepository;
import com.example.photo_gallery.modules.users.repositories.UsersRepository;

@Service
public class UploadPhotoService {

    @Autowired
    private PhotosRepository photosRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GalleryRepository galleriesRepository;

    public UploadPhotoResponseDTO execute(UploadPhotoDTO payload) {
        Gallery galleryExists = galleriesRepository.findById(payload.getGalleryId()).orElse(null);
        if (galleryExists == null) {
            throw new RuntimeException("Gallery not found");
        }

        Photo photo = payload.toEntity();
        photo.setGallery(galleryExists);

        photosRepository.save(photo);
        return new UploadPhotoResponseDTO(photo.getId(), photo.getName(), photo.getDescription(), photo.getBase64(),
                galleryExists.getId(), galleryExists.getName(), photo.getCreatedAt());
    }
}
