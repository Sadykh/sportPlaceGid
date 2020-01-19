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
public class PlaceRouter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Place place;

    @ManyToOne
    private PlaceRouterLevel level;

    private int height;

    private int length;

    private long createdAt;

    private long updatedAt;

    public PlaceRouter(String name, int height, int length, PlaceRouterLevel level, Place place) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.level = level;
        this.place = place;
    }


    @Override
    public String toString() {
        return String.format("PlaceRouter[id='%d',  name = '%s']", id, name);
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
