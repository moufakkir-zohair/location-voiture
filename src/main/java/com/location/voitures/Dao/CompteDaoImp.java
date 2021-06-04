package com.location.voitures.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Compte;
import com.location.voitures.Entity.CompteClient;
import com.location.voitures.Entity.CompteManager;
import com.location.voitures.Entity.Location;
import com.location.voitures.Repository.CompteClientRepository;
import com.location.voitures.Repository.CompteManagerRepository;
import com.location.voitures.Repository.CompteRepository;


@Service
public class CompteDaoImp  implements ICompteDao{

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private CompteClientRepository compteClientRepository;
	
	@Autowired
	private CompteManagerRepository compteManagerRepository;
	
	
	@Override
	public Compte AjouterCompte(Compte C) {
		return compteRepository.save(C);
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

	@Override
	public List<CompteClient> ListeCompteClient() {
		return compteClientRepository.findAll();
	}

	@Override
	public List<CompteManager> ListeCompteManager() {
		return compteManagerRepository.findAll();
	}

	@Override
	public List<Location> ListeLocationCompte(Long id) {
		CompteClient CC = (CompteClient) ChercherCompte(id);
		return CC.getLocations();
	}


	

}
