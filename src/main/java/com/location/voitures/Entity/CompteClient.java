package com.location.voitures.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("CC")
public class CompteClient extends Compte implements Serializable{

	
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Location> locations;
	
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    private List<Commentaire> commentaires;
	
	
	public CompteClient() {
		super();
	}

	

	public CompteClient(String cin, String prenom, String email, String tele, String adresse, String nationalite,
			String motpasse) {
		super(cin, prenom, email, tele, adresse, nationalite, motpasse);
		// TODO Auto-generated constructor stub
	}



	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
}
