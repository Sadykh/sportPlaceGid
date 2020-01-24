package com.sportPlaceGid.infrastructure.repository;

import com.sportPlaceGid.domain.OauthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessTokenRepository extends JpaRepository<OauthAccessToken, String> {

}
