package com.example.photo_gallery.modules.galleries.dto;


import com.example.photo_gallery.modules.galleries.model.Gallery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GalleryDTO {

    public GalleryDTO() {
    }

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 50, message = "Description must be between 2 and 50 characters")
    private String description;

    @NotNull(message = "IsPublic status is required")
    private Boolean isPublic;

    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Gallery toEntity() {
        Gallery gallery = new Gallery();
        gallery.setName(this.name);
        gallery.setDescription(this.description);
        gallery.setIsPublic(this.isPublic);
        gallery.setIsActive(true);
        return gallery;
    }
}
