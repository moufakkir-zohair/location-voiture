package com.location.voitures.Entity;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type_Compte", discriminatorType = DiscriminatorType.STRING )
public abstract class  Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_compte ;
	private String cin;
	private String prenom;
	private String email;
	private String motpasse;
	private String tele;
	private String adresse;
	private String nationalite;
	
	
	public Compte() {
		super();
	}
	

	public Compte(String cin, String prenom, String email, String tele, String adresse, String nationalite,String motpasse) {
		super();
		this.cin = cin;
		this.prenom = prenom;
		this.email = email;
		this.motpasse = motpasse;
		this.tele = tele;
		this.adresse = adresse;
		this.nationalite = nationalite;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public Long getId_compte() {
		return id_compte;
	}


	public String getMotpasse() {
		return motpasse;
	}


	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}
	
	
		
}
