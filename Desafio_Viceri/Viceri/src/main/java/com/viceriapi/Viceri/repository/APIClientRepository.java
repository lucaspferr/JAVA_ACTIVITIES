package com.viceriapi.Viceri.repository;

import com.viceriapi.Viceri.entity.APIClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIClientRepository extends JpaRepository<APIClient,Long> {
    public APIClient findByEmail(String email);
}
