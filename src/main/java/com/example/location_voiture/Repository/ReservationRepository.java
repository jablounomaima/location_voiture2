package com.example.location_voiture.Repository;

import com.example.location_voiture.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
