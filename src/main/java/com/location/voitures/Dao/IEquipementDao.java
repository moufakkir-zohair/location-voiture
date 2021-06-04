package com.location.voitures.Dao;

import java.util.List;

import com.location.voitures.Entity.Equipement;

public interface IEquipementDao {
	public Equipement AjouterEquipement(Equipement E);
	public void SupprimerEquipement(Long id_equipement);
	public Equipement ModifierEquipemet(Equipement E);
	public List<Equipement> ListEquipment();
	public Equipement ChercherEquipement(Long id_equipement);
}
