package com.location.voitures.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.location.voitures.Entity.Compte;
import com.location.voitures.Entity.CompteClient;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	Compte findByEmailAndMotpasse(String email, String motpasse);

}
