package com.example.location_voiture.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Gestionnaire extends Utilisateur1 {
    public String nomAgence;
    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL)
    private List<Voiture> voitures=new ArrayList<>();

}
