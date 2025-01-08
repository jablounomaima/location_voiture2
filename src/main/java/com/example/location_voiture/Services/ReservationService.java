package com.example.location_voiture.Services;

import com.example.location_voiture.Models.Reservation;
import com.example.location_voiture.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {


    private ReservationRepository reservationRepository;

    // Create Reservation
    // Créer une nouvelle réservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation); // Enregistrer la réservation dans la base de données
    }

    // Récupérer toutes les réservations
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll(); // Retourner la liste de toutes les réservations
    }

    // Get Reservation by ID
    public Reservation getReservationById(long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.orElse(null);
    }

    // Update Reservation
    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    // Delete Reservation
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }
}
