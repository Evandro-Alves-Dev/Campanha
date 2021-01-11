package com.campanha.time.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campanha.time.models.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}
