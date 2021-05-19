package com.location.voitures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.voitures.Entity.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {

}
