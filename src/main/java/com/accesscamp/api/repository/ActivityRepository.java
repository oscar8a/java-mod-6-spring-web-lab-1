package com.accesscamp.api.repository;

import com.accesscamp.api.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    void deleteById(Long id);
}
