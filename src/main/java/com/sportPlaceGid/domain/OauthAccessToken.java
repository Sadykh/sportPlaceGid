package com.sportPlaceGid.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OauthAccessToken {

    @Id
    private String authenticationId;

    private String tokenId;

    @Column(columnDefinition="LONG VARBINARY NOT NULL")
    private byte[] token;
    private String userName;
    private String clientId;

    @Column(columnDefinition="LONG VARBINARY NOT NULL")
    private byte[] authentication;
    private String refreshToken;
}
