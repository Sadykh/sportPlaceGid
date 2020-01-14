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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    private String passwordHash;

    private long createdAt;

    private long updatedAt;

    public User(String email, String passwordHash, String name) {
        this.email = email;
        this.name = name;
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return String.format("User[id='%d', email = '%s', name = '%s']", id, email, name);
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
