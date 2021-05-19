package com.location.voitures.Entity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;


@Entity
public class Equipement implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_equipement;
	private String nom;
	
	
	
	@ManyToOne  
	   @JoinTable( name = "Equipements_voiture",
       joinColumns = @JoinColumn( name = "id_equipement" ),
       inverseJoinColumns = @JoinColumn( name = "id_voiture" ) )
    private Voiture voiture;
	
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
	
	
	
}
