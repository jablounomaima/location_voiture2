package com.example.location_voiture.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class imagController {

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    // Afficher le formulaire
    @GetMapping("/form")
    public String showForm(Model model) {
        return "form"; // Correspond au fichier `form.html`
    }

    // Gérer le téléchargement de l'image
    @PostMapping("/submit")
    public String handleForm(@RequestParam("file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                // Sauvegarder l'image dans le dossier uploads
                String fileName = file.getOriginalFilename();
                File destination = new File(UPLOAD_DIR + fileName);
                file.transferTo(destination);

                // Ajouter le chemin de l'image pour l'afficher après l'envoi
                model.addAttribute("imagePath", "/uploads/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Erreur lors de l'upload de l'image");
                return "form";
            }
        }
        return "result"; // Page pour afficher l'image après l'envoi
    }
}
