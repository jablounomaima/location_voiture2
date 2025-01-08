package com.example.location_voiture.Services;

import com.example.location_voiture.Models.Facture;
import com.example.location_voiture.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    @Autowired
    private FactureRepository factureRepository;

    public void saveFacture(Facture facture) {
        factureRepository.saveAndFlush(facture); // Utilise save pour ajouter une nouvelle facture
    }
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }


}
