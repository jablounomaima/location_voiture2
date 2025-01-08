package com.example.location_voiture.Repository;

import com.example.location_voiture.Models.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Long> {
}
