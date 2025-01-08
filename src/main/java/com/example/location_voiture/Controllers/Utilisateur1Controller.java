package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Utilisateur1;
import com.example.location_voiture.Models.Voiture;
import com.example.location_voiture.Services.Utilisateur1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Utilisateur1Controller {

    @Autowired
    private Utilisateur1Service utilisateur1Service;

//    // Formulaire pour ajouter un utilisateur
//    @GetMapping("/addUtilisateur")
//    public String addUtilisateurForm(Model model) {
//        Utilisateur1 utilisateur = new Utilisateur1();
//        model.addAttribute("UtilisateurForm", utilisateur);
//        return "newUtilisateur"; // Vue pour ajouter un utilisateur
//    }
//
//    // Sauvegarder un utilisateur
//    @PostMapping("/saveUtilisateur")
//    public String saveUtilisateur(@ModelAttribute("UtilisateurForm") Utilisateur1 utilisateur) {
//        utilisateur1Service.createUtilisateur(utilisateur); // Sauvegarde l'utilisateur
//        return "redirect:/allUtilisateurs"; // Redirige vers la liste des utilisateurs
//    }

    // Liste des utilisateurs
    @GetMapping("/allUtilisateurs")
    public String listUtilisateurs(Model model) {
        List<Utilisateur1> utilisateurs = utilisateur1Service.getAllUtilisateurs();
        model.addAttribute("listUtilisateurs", utilisateurs);
        return "listUtilisateurs"; // Vue pour afficher les utilisateurs
    }
//
    // Supprimer un utilisateur
    @GetMapping("/deleteUtilisateur/{id}")
    public String deleteUtilisateur(@PathVariable long id) {
        utilisateur1Service.deleteUtilisateur(id); // Supprime l'utilisateur
        return "redirect:/allUtilisateurs";
   }

    // Modifier un utilisateur
    @GetMapping("/editUtilisateur/{id}")
    public String editUtilisateur(@PathVariable long id, Model model) {
        // Récupère l'utilisateur par ID
        Utilisateur1 utilisateur = utilisateur1Service.getUtilisateurById(id);

        // Si l'utilisateur n'existe pas, renvoie une page d'erreur
        if (utilisateur == null) {
            model.addAttribute("errorMessage", "Utilisateur non trouvé");
            return "errorPage";
        }

        // Ajoute l'utilisateur au modèle pour l'afficher dans le formulaire
        model.addAttribute("UtilisateurForm", utilisateur);

        // Retourne la vue de modification de l'utilisateur
        return "updateUtilisateur";
    }


    // Mettre à jour un utilisateur
    @PostMapping("/updateUtilisateur/{id}")
    public String updateUtilisateur(@ModelAttribute("UtilisateurForm") Utilisateur1 utilisateur, @PathVariable long id) {
        // Vérification si l'utilisateur existe
        Utilisateur1 existingUtilisateur = utilisateur1Service.getUtilisateurById(id);
        if (existingUtilisateur == null) {
            return "errorPage"; // Si l'utilisateur n'existe pas, retourner une page d'erreur
        }

        // Mettre à jour les informations de l'utilisateur existant
        existingUtilisateur.setNom(utilisateur.getNom());
        existingUtilisateur.setPrenom(utilisateur.getPrenom());
        existingUtilisateur.setEmail(utilisateur.getEmail());
        existingUtilisateur.setMotDePasse(utilisateur.getMotDePasse());
        existingUtilisateur.setRole(utilisateur.getRole());

        utilisateur1Service.updateUtilisateur(existingUtilisateur); // Sauvegarder la mise à jour

        return "redirect:/allUtilisateurs"; // Rediriger vers la liste des utilisateurs après la mise à jour
    }



    // Méthode pour afficher le formulaire d'ajout
    @GetMapping("/addUtilisateur")
    public String showAddUtilisateurForm(Model model) {
        model.addAttribute("UtilisateurForm", new Utilisateur1()); // Ajouter un nouvel objet Utilisateur1 vide
        return "addUtilisateur"; // Vue pour ajouter un utilisateur
    }

    // Méthode pour enregistrer l'utilisateur
    @PostMapping("/saveUtilisateur")
    public String saveUtilisateur(@ModelAttribute("UtilisateurForm") Utilisateur1 utilisateur) {
        utilisateur1Service.saveUtilisateur(utilisateur); // Appeler le service pour enregistrer l'utilisateur
        return "redirect:/allUtilisateurs"; // Rediriger vers la liste des utilisateurs
    }






}
