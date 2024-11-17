package com.example.location_voiture.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;



@Entity
@Getter
@Setter
    @Inheritance(strategy = InheritanceType.JOINED)
    public class Utilisateur1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;
        public String nom;
        public String prenom;

        public String email;
        public String motDePasse;
        public Role role;

}
