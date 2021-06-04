package com.location.voitures.Dao;

import java.util.Date;
import java.util.List;

import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

public interface ILocationDao {

	public Location AjouterLocation(Location L);
	public void AccepterLocation(Long id_location);
	public void EffectuerLocation(Long id_location);
	public Location ChercherLocation(Long id_location);
	public int VerifierLocation(Long id_voiture , Date date);
	public List<Location> ListeLocation();
	public Voiture VoitureLocation(Long id_location);
	
}
