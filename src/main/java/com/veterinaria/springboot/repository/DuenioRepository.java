package com.veterinaria.springboot.repository;

import com.veterinaria.springboot.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenioRepository extends JpaRepository<Duenio, Long> {
}
