package com.location.voitures.Entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CompteAdmin extends Compte implements Serializable{

	public CompteAdmin() {
		super();
	}

	public CompteAdmin(String cin, String prenom, String email, String tele, String adresse, String nationalite,
			String motpasse) {
		super(cin, prenom, email, tele, adresse, nationalite, motpasse);
	}

	

}
