package com.location.voitures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.voitures.Entity.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {

}
