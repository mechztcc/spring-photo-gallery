package com.example.photo_gallery.modules.photos.dto;

import com.example.photo_gallery.modules.photos.model.Photo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UploadPhotoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters")
    private String description;

    @NotBlank(message = "Base64 data is required")
    private String base64;

    @NotBlank(message = "Gallery ID is required")
    private Long galleryId;

    public UploadPhotoDTO() {
    }

    public Long getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }

    public void setOwnerId(Long galleryId) {
        this.galleryId = galleryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Photo toEntity() {
        Photo photo = new Photo();
        photo.setId(this.id);
        photo.setName(this.name);
        photo.setDescription(this.description);
        photo.setBase64(this.base64);
        return photo;
    }

}
