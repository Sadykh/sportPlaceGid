package com.sportPlaceGid.domain;

import com.sportPlaceGid.infrastructure.dto.place.PlaceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne
    private Category category;

    @ManyToOne
    private City city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private Set<PlaceService> services;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private Set<PlaceRouter> routers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
    private Set<PlaceImage> placeImages;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String working_hours_weekday_from;

    @Column(nullable = false)
    private String working_hours_weekday_to;

    @Column(nullable = false)
    private String working_hours_weekend_from;

    @Column(nullable = false)
    private String working_hours_weekend_to;

    private long createdAt;

    private long updatedAt;


    public Place(String name, Category category, City city, String description, String working_hours_weekday_from, String working_hours_weekday_to, String working_hours_weekend_from, String working_hours_weekend_to) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.description = description;
        this.working_hours_weekday_from = working_hours_weekday_from;
        this.working_hours_weekday_to = working_hours_weekday_to;
        this.working_hours_weekend_from = working_hours_weekend_from;
        this.working_hours_weekend_to = working_hours_weekend_to;
    }

    public Place(PlaceDto placeDto, Category category, City city) {
        this.name = placeDto.getName();
        this.category = category;
        this.city = city;
        this.description = placeDto.getDescription();
        this.working_hours_weekday_from = placeDto.getWorking_hours_weekday_from();
        this.working_hours_weekday_to = placeDto.getWorking_hours_weekday_to();
        this.working_hours_weekend_from = placeDto.getWorking_hours_weekend_from();
        this.working_hours_weekend_to = placeDto.getWorking_hours_weekend_to();
        this.address = placeDto.getAddress();
        this.longitude = placeDto.getLongitude();
        this.latitude = placeDto.getLatitude();
    }

    @Override
    public String toString() {
        return String.format("Category[id='%d',  name = '%s']", id, name);
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
