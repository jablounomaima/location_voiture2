package com.example.location_voiture.Services;

import ch.qos.logback.core.model.Model;
import com.example.location_voiture.Models.Client;
import com.example.location_voiture.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void CreateClient(Client client) {
        clientRepository.save(client);
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    public  Client getProductByID(Long id) {
        return clientRepository.findById(id).get();
    }



    public Client updateProduct(Client client) {

        return clientRepository.saveAndFlush(client); // Persister les modifications
    }


    //public  Client updateProduct(Client client) {
      //  return clientRepository.saveAndFlush(client);
    //}

    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }



}
