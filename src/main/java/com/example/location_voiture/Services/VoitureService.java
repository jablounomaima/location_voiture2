package com.example.location_voiture.Services;

import com.example.location_voiture.Models.Voiture;
import com.example.location_voiture.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoitureService {
    @Autowired
     VoitureRepository voitureRepository;
    public Voiture createVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);


    }

    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();

    }


    public Voiture getVoitureById(long id) {
        return voitureRepository.findById(id).get();

    }




    public void deleteVoiture(long id) {

        voitureRepository.deleteById(id);
    }

    public Voiture updateVoiture( Voiture voiture) {

        return voitureRepository.saveAndFlush(voiture);
    }



}
