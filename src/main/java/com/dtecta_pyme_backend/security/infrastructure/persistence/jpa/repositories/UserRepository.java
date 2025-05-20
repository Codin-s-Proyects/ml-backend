package com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories;

import com.dtecta_pyme_backend.security.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    User findByUsername(String username);

}