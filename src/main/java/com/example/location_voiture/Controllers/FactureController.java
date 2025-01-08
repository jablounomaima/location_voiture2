package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Facture;
import com.example.location_voiture.Services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FactureController {

    @Autowired
    private FactureService factureService; // Injection du service FactureService

    // Méthode pour afficher le formulaire d'ajout
    @GetMapping("/addFacture")
    public String showAddFactureForm(Model model) {
        model.addAttribute("FactureForm", new Facture()); // Ajouter un nouvel objet Facture vide
        return "facture/addFacture"; // Vue pour ajouter une facture
    }

    // Méthode pour enregistrer la facture
    @PostMapping("/saveFacture")
    public String saveFacture(@ModelAttribute("FactureForm") Facture facture) {
        factureService.saveFacture(facture); // Appeler le service pour enregistrer la facture
        return "redirect:/allFactures"; // Rediriger vers la liste des factures
    }
    @GetMapping("/allFactures")
    public String getAllFactures(Model model) {
        List<Facture> factures = factureService.getAllFactures();
        model.addAttribute("listFactures", factures);
        return "facture/listFactures"; // Vue pour afficher les factures
    }


}
