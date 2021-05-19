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

@Entity
public class Location implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_location;
	private Date date_debut;
	private Date date_fin;
	private boolean acceptee;
	private boolean effectuee;
	
	
	@ManyToOne  (fetch = FetchType.LAZY)
	@JoinColumn( name="id_voiture" )
	private Voiture voiture;
	
	
	@ManyToOne  (fetch = FetchType.LAZY)
	@JoinColumn( name="id_compte" )
	private CompteClient client;
	
	
	public Location() {
		super();
	}

	public Location(Date date_debut, Date date_fin, boolean acceptee, boolean effectuee) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.acceptee = acceptee;
		this.effectuee = effectuee;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public boolean isAcceptee() {
		return acceptee;
	}

	public void setAcceptee(boolean acceptee) {
		this.acceptee = acceptee;
	}

	public boolean isEffectuee() {
		return effectuee;
	}

	public void setEffectuee(boolean effectuee) {
		this.effectuee = effectuee;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
}
