package com.sportPlaceGid.infrastructure.repository;

import com.sportPlaceGid.domain.OauthRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRefreshTokenRepository extends JpaRepository<OauthRefreshToken, String> {

}
