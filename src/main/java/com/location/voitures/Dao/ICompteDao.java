package com.location.voitures.Dao;

import com.location.voitures.Entity.Compte;

public interface ICompteDao {

	public void AjouterCompte(Compte C);
	public void ModifierCompte(Compte C);
	public void SupprimerCompte(Long id_compte);
	public Compte ChercherCompte(Long id_compte);
	public Compte VerifierCompte(String Email, String motpasse);
	
}
