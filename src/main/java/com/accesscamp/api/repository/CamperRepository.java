package com.accesscamp.api.repository;

import com.accesscamp.api.model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamperRepository extends JpaRepository<Camper, Long> {
}
