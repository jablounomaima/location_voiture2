package com.example.location_voiture.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public long id;
    @Temporal(TemporalType.DATE)
    public Date datedebut;
    @Temporal(TemporalType.DATE)
    public Date dateFin;
    public Double montantTotale;
    public String status;
    @ManyToOne
    @JoinColumn(name="client-id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="Voiture")
    private Voiture voiture;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Facture facture;


}
