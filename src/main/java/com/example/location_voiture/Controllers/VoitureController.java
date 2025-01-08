package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Voiture;
import com.example.location_voiture.Services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/"; // Répertoire cible

    // Afficher le formulaire pour ajouter une nouvelle voiture
    @RequestMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        model.addAttribute("VoitureForm", voiture);
        return "voitures/new_Voiture";
    }

    // Gestion de l'upload d'une image
    @PostMapping("/submit")
    public String handleForm(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                File destination = new File(UPLOAD_DIR + fileName);
                file.transferTo(destination);

                model.addAttribute("imagePath", "/uploads/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Erreur lors de l'upload de l'image");
                return "addVoiture";
            }
        }
        return "voitures/new_Voiture";
    }

    // Sauvegarder une nouvelle voiture
    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture) {
        voitureService.createVoiture(voiture);
        return "redirect:/all2";
    }

    // Afficher la liste des voitures
    @RequestMapping("/all2")
    public String all2(Model model) {
        List<Voiture> listVoitures = voitureService.getAllVoiture();
        model.addAttribute("listVoitures", listVoitures);
        return "voitures/list_Voitures";
    }

    // Supprimer une voiture
    @GetMapping("delet2/{id}")
    public String deleteVoiture(@PathVariable("id") long id) {
        voitureService.deleteVoiture(id);
        return "redirect:/all2";
    }

    // Modifier une voiture
    @GetMapping("edit2/{id}")
    public String editVoiture(@PathVariable("id") long id, Model model) {
        Voiture voiture = voitureService.getVoitureById(id);
        model.addAttribute("voiture", voiture);
        return "voitures/update_Voiture";
    }

    // Mettre à jour une voiture
    @PostMapping("update2/{id}")
    public String updateVoitures(@PathVariable("id") Long id, @ModelAttribute Voiture voiture) {
        voitureService.updateVoiture(voiture);
        return "redirect:/all2";
    }
}
