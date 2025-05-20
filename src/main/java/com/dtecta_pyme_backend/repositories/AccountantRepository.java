package com.dtecta_pyme_backend.repositories;

import com.dtecta_pyme_backend.domain.model.entities.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {
}
