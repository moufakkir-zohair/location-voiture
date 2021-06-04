package com.location.voitures.Entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Equipement implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_equipement;
	private String nom;
	
	
	@ManyToMany(mappedBy = "equipements")
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Voiture> voitures ;
	
	
	public Equipement() {
		super();
	}


	public Equipement(String nom) {
		super();
		this.nom = nom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Long getId_equipement() {
		return id_equipement;
	}


	public List<Voiture> getVoitures() {
		return voitures;
	}


	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	
	
}
