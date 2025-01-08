package com.example.location_voiture.Repository;

import com.example.location_voiture.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
