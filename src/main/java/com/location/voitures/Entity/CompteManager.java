package com.location.voitures.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CM")
public class CompteManager extends Compte implements Serializable{

	public CompteManager() {
		super();
	}

	public CompteManager(String cin, String prenom, String email, String tele, String adresse, String nationalite,
			String motpasse) {
		super(cin, prenom, email, tele, adresse, nationalite, motpasse);
		// TODO Auto-generated constructor stub
	}

	

	
}
