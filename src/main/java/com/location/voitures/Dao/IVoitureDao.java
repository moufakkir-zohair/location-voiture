package com.location.voitures.Dao;

import java.util.List;

import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Equipement;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

public interface IVoitureDao {
	
	public Voiture AjouterVoiture(Voiture V);
	public Voiture ModifierVoiture(Voiture V);
	public void SupprimerVoiture(Long id_voiture);
    public void AffecterEquipement(Long id_equipement , Long id_voiture);
    public Voiture ChercherVoiture(Long id_voiture);
    public List<Equipement> ListeEquipementVoiture(Long id_voiture);
    public List<Commentaire> ListCommentaireVoiture(Long id_voiture);
    public List<Location> ListLocationVoiture(Long id_voiture);
    public List<Voiture> ListVoiture();
    
}
