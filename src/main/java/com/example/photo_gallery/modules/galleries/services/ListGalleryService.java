package com.example.photo_gallery.modules.galleries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.galleries.dto.CreateGalleryResponseDTO;
import com.example.photo_gallery.modules.galleries.repositories.GalleryRepository;

@Service
public class ListGalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public Page<CreateGalleryResponseDTO> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return galleryRepository.findAll(pageable).map(gallery -> new CreateGalleryResponseDTO(
                gallery.getId(),
                gallery.getName(),
                gallery.getDescription(),
                gallery.getIsPublic(),
                gallery.getCreatedAt(),
                gallery.getUpdatedAt()));

    }
}
