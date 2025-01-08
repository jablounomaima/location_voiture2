package com.example.location_voiture.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue
    public long id;
    public Date dateEmission;
    public Double montantTotale;
    @OneToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;
}
