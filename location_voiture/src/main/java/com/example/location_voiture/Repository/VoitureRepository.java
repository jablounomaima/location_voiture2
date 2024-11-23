package com.example.location_voiture.Repository;

import com.example.location_voiture.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
