package com.location.voitures.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Compte;
import com.location.voitures.Repository.CompteRepository;


@Service
public class CompteDaoImp  implements ICompteDao{

	@Autowired
	private CompteRepository compteRepository;
	
	
	@Override
	public void AjouterCompte(Compte C) {
		compteRepository.save(C);
	}

	@Override
	public void ModifierCompte(Compte C) {
		compteRepository.save(C);
	}

	@Override
	public void SupprimerCompte(Long id_compte) {
		compteRepository.deleteById(id_compte);
	}

	@Override
	public Compte ChercherCompte(Long id_compte) {
		return compteRepository.findById(id_compte).orElse(null);
	}

	@Override
	public Compte VerifierCompte(String Email, String motpasse) {
		return compteRepository.findByEmailAndMotpasse(Email,motpasse);
	}

}
