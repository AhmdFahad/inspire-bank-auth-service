package com.inspire.auth.repository;

import com.inspire.auth.model.ClientCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ClientCredentials,Long> {
    Optional<ClientCredentials> findByEmail(String email);

}
