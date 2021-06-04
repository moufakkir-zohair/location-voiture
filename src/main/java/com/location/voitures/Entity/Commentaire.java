package com.location.voitures.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Commentaire implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commentaire;
	private String commentaire;
	private Date date;
	
	@ManyToOne (fetch = FetchType.LAZY) 
	@JoinColumn( name="id_voiture" )
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Voiture voiture ;
	
	@ManyToOne (fetch = FetchType.LAZY) 
	@JoinColumn( name="id_compte" )
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CompteClient client;
	
	public Commentaire() {
		super();
	}

	

	public Commentaire(String commentaire, Date date, Voiture voiture , CompteClient client) {
		super();
		this.commentaire = commentaire;
		this.date = date;
		this.voiture = voiture;
		this.client = client;
	}

	public Commentaire(String commentaire, Date date , CompteClient client) {
		super();
		this.commentaire = commentaire;
		this.date = date;
		this.client = client;
	}



	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId_commentaire() {
		return id_commentaire;
	}

	
	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
	public CompteClient getClient() {
		return client;
	}

	public void setClient(CompteClient client) {
		this.client = client;
	}
	
	
}
