package com.sportPlaceGid.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlaceImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long createdAt;

    private long updatedAt;

    @ManyToOne
    private Place place;

    @ManyToOne
    private FileImage image;


    @Override
    public String toString() {
        return String.format("PlaceImage[id='%d', imageId = '%s']", id, image.getId());
    }


    public PlaceImage(Place place, FileImage fileImage) {
        this.image = fileImage;
        this.place = place;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now().getEpochSecond();
        updatedAt = Instant.now().getEpochSecond();
    }


    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now().getEpochSecond();
    }
}
