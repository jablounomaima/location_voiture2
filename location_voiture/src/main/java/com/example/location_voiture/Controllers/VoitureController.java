package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Voiture;
import com.example.location_voiture.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class VoitureController {

    @Autowired

    private VoitureService voitureService; // Injection du service corrigée

    // Afficher le formulaire pour ajouter une nouvelle voiture
    @RequestMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        model.addAttribute("VoitureForm", voiture); // Ajout correct de l'attribut au modèle
        return "voitures/new_Voiture"; // Renvoie vers la vue pour ajouter une voiture

    }

    // Sauvegarder une nouvelle voiture
    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture) {
        voitureService.createVoiture(voiture);
         // Utilisation du service pour sauvegarder
        return "redirect:/all2"; // Redirection vers la liste des voitures après sauvegarde
    }



    //afficher dans un page la liste

    @RequestMapping("/all2")
    public String all2(Model model) {
        List<Voiture> listVoitures = voitureService.getAllVoiture();
        model.addAttribute("listVoitures",listVoitures);
        return "voitures/list_Voitures";

    }

    @GetMapping("delet2/{id}")
    public String deleteVoiture(@PathVariable("id") long id) {
        voitureService.deleteVoiture(id);
        return "redirect:/all2";

    }

    @GetMapping("edit2/{id}")
    public String editVoiture(@PathVariable("id") long id, Model model) {
        // Récupérer la voiture par ID
        Voiture voiture = voitureService.getVoitureById(id);

        // Ajouter la voiture au modèle pour préremplir le formulaire
        model.addAttribute("voiture", voiture);
        return "voitures/update_Voiture"; // Vue pour modifier la voiture
    }

    @PostMapping("update2/{id}")
    public String updateVoitures(@ModelAttribute("id") Long id, @ModelAttribute Voiture voiture, Model model) {
        voitureService.updateVoiture(voiture);
        return "redirect:/all2";
    }



    }



























