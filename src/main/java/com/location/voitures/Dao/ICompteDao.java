package com.location.voitures.Dao;

import java.util.List;

import com.location.voitures.Entity.Compte;
import com.location.voitures.Entity.CompteClient;
import com.location.voitures.Entity.CompteManager;
import com.location.voitures.Entity.Location;

public interface ICompteDao {

	public Compte AjouterCompte(Compte C);
	public void ModifierCompte(Compte C);
	public void SupprimerCompte(Long id_compte);
	public Compte ChercherCompte(Long id_compte);
	public Compte VerifierCompte(String Email, String motpasse);
	
	public  List<CompteClient> ListeCompteClient();
	public  List<CompteManager> ListeCompteManager();
	public List<Location> ListeLocationCompte(Long id);
	
}
