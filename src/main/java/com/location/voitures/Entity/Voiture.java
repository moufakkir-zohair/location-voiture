package com.location.voitures.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Voiture implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_voiture;
	private String nom;
	private String photo;
	private String type;
	private String matricule;
	private float prix;
	private String modele;
	private int annee_modele;
	private String marque;
	private String description;
	private String carburant;
	private String boiteAvitesse;
	private String puissanceFiscale;
	
	
	@ManyToMany
    @JoinTable( name = "Equipements_voiture",
                joinColumns = @JoinColumn( name = "id_voiture" ),
                inverseJoinColumns = @JoinColumn( name = "id_equipement"))
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Equipement> equipements= new ArrayList<>();
	
	
	@OneToMany(mappedBy = "voiture", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Location> locations;
	
	
	@OneToMany(mappedBy = "voiture", cascade = CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Commentaire> commentaires ;
	
	
	
	public Voiture() {
		super();
	}


	public Voiture(String nom, String photo, String type, String matricule, float prix, String modele, int annee_modele,
			String marque, String description, String carburant, String boiteAvitesse, String puissanceFiscale) {
		super();
		this.nom = nom;
		this.photo = photo;
		this.type = type;
		this.matricule = matricule;
		this.prix = prix;
		this.modele = modele;
		this.annee_modele = annee_modele;
		this.marque = marque;
		this.description = description;
		this.carburant = carburant;
		this.boiteAvitesse = boiteAvitesse;
		this.puissanceFiscale = puissanceFiscale;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public int getAnnee_modele() {
		return annee_modele;
	}


	public void setAnnee_modele(int annee_modele) {
		this.annee_modele = annee_modele;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCarburant() {
		return carburant;
	}


	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}


	public String getBoiteAvitesse() {
		return boiteAvitesse;
	}


	public void setBoiteAvitesse(String boiteAvitesse) {
		this.boiteAvitesse = boiteAvitesse;
	}


	public String getPuissanceFiscale() {
		return puissanceFiscale;
	}


	public void setPuissanceFiscale(String puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}


	public Long getId_voiture() {
		return id_voiture;
	}


	public List<Equipement> getEquipements() {
		return equipements;
	}


	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
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
