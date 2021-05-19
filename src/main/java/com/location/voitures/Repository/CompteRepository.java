package com.location.voitures.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.voitures.Entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

	Compte findByEmailAndMotpasse(String email, String motpasse);

}
