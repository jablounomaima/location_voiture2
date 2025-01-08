package com.example.location_voiture.Services;

import com.example.location_voiture.Models.Utilisateur1;
import com.example.location_voiture.Repository.Utilisateur1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Utilisateur1Service {
    @Autowired
    private Utilisateur1Repository utilisateur1Repository;

    // Récupérer tous les utilisateurs
    public List<Utilisateur1> getAllUtilisateurs() {
        return utilisateur1Repository.findAll();
    }

    // Récupérer un utilisateur par ID
    public Utilisateur1 getUtilisateurById(Long id) {
        return utilisateur1Repository.findById(id).orElse(null); // Retourne null si l'utilisateur n'est pas trouvé
    }

    // Supprimer un utilisateur
    public void deleteUtilisateur(Long id) {
        utilisateur1Repository.deleteById(id);
    }

    // Mettre à jour un utilisateur
    public void updateUtilisateur(Utilisateur1 utilisateur) {
        utilisateur1Repository.saveAndFlush(utilisateur); // La méthode save de JpaRepository fait la mise à jour si l'entité existe
    }

    // Méthode pour enregistrer un utilisateur
    public void saveUtilisateur(Utilisateur1 utilisateur) {
        utilisateur1Repository.save(utilisateur); // Utilise save pour ajouter un nouvel utilisateur à la base de données
    }


}
