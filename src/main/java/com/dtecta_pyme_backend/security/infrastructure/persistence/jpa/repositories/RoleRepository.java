package com.dtecta_pyme_backend.security.infrastructure.persistence.jpa.repositories;

import com.dtecta_pyme_backend.security.domain.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);

    boolean existsByName(String name);

}
