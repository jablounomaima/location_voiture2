package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Client;
import com.example.location_voiture.Models.Reservation;
import com.example.location_voiture.Models.Voiture;
import com.example.location_voiture.Services.ClientService;
import com.example.location_voiture.Services.ReservationService;
import com.example.location_voiture.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private ClientService clientService;
    private VoitureService voitureService;


    // Page pour ajouter une nouvelle réservation
    @GetMapping("/addReservation")
    public String addReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservationForm", reservation);

        // Ajouter la liste des clients et voitures au modèle
        List<Client> clients = clientService.getAllClients();
        List<Voiture> voitures = voitureService.getAllVoiture();
        model.addAttribute("clients", clients);
        model.addAttribute("voitures", voitures);

        return "reservation/newReservation"; // Vue pour ajouter une réservation
    }

    // Sauvegarder une nouvelle réservation
    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservationForm") Reservation reservation) {
        // Assurez-vous que le service de création fonctionne correctement
        reservationService.createReservation(reservation);
        return "redirect:/allReservations"; // Redirige vers la liste des réservations
    }

    // Liste des réservations
    @GetMapping("/allReservations")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservation();
        model.addAttribute("listReservations", reservations);
        return "reservation/allReservations"; // Vue pour afficher la liste des réservations
    }

    // Modifier une réservation
    @GetMapping("/editReservation/{id}")
    public String editReservation(@PathVariable long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return "errorPage"; // Si la réservation n'existe pas
        }
        model.addAttribute("reservationForm", reservation);
        return "reservation/editReservation"; // Vue pour éditer une réservation
    }

    // Mettre à jour une réservation
    @PostMapping("/updateReservation/{id}")
    public String updateReservation(@ModelAttribute("reservationForm") Reservation reservation, @PathVariable long id) {
        reservation.setId(id);
        reservationService.updateReservation(reservation);
        return "redirect:/allReservations"; // Redirige vers la liste des réservations
    }

    // Supprimer une réservation
    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
        return "redirect:/allReservations"; // Redirige vers la liste des réservations
    }

}
