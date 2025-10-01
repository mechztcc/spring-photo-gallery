package com.example.photo_gallery.modules.photos.dto;

import java.time.LocalDateTime;

public class UploadPhotoResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String base64;
    private Long galleryId;
    private String galleryName;
    private LocalDateTime createdAt;

    public UploadPhotoResponseDTO(Long id, String name, String description, String base64, Long galleryId,
            String galleryName, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.base64 = base64;
        this.galleryId = galleryId;
        this.galleryName = galleryName;
        this.createdAt = createdAt;
    }

    // setters

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    public String getGalleryName() {
        return galleryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    };

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBase64() {
        return base64;
    }

    public Long getGalleryId() {
        return galleryId;
    }
}
