package com.location.voitures.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cm")
public class CompteManager extends Compte implements Serializable{

	public CompteManager() {
		super();
	}

	public CompteManager(String cin, String prenom, String email, String tele, String adresse, String nationalite,
			String motpasse) {
		super(cin, prenom, email, tele, adresse, nationalite, motpasse);
	}

		
}
