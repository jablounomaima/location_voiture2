package com.example.location_voiture.Controllers;

import com.example.location_voiture.Models.Client;
import com.example.location_voiture.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
//import org.springframework.ui.Model; important d'ajouter cette ligne

@Controller

public class ClientController {
    @Autowired
    private ClientService clientService;
    @RequestMapping("/addClient")
    public String addProduct(Model model) {
        Client client = new Client();
        model.addAttribute("ClientForm", client);
        return "newClient";
    }


@RequestMapping(value=("/save"),method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("ClientForm") Client client) {
        clientService.CreateClient(client);
        return "redirect:/all";

}
   // @GetMapping("/test")
    //public String testPage() {
    //turn "test";
   //


@RequestMapping(value = "/all")
public String listClient(Model model){
    List<Client> listClient2=clientService.getAllClients();
    model.addAttribute("listClient",listClient2);
    return "listClient2";
    }


    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
        return "redirect:/all";
    }

    @GetMapping("edit/{id}")
    public String editClient(@PathVariable long id, Model model) {
        Client client= clientService.getProductByID(id);
        model.addAttribute("ClientForm", client);
        return "update_Client";
    }

    @PostMapping("update/{id}")
    public String updateClient( @ModelAttribute("ClientForm") Client client,@PathVariable long id) {
        client.setId(id);
        clientService.updateProduct(client);
        return "redirect:/all";

    }







}





