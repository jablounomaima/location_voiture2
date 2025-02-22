package com.example.location_voiture.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Voiture {
    @Id
    @GeneratedValue
    public long id;
    public String marque;
    public String modele;
    public String categorie;
    public boolean disponible;
    public double prixPourJour;

    @ManyToOne
    @JoinColumn(name="gestionnaire_id")
    private Gestionnaire gestionnaire;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
}
