package com.sportPlaceGid.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;
    private long createdAt;

    private long updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Set<Place> places;

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("City[id='%d',  name = '%s']", id, name);
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
