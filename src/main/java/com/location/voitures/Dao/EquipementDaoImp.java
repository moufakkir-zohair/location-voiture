package com.location.voitures.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Equipement;
import com.location.voitures.Entity.Voiture;
import com.location.voitures.Repository.EquipementRepository;
import com.location.voitures.Repository.VoitureRepository;


@Service
public class EquipementDaoImp implements IEquipementDao {

	@Autowired
	private EquipementRepository equipementRepository;
	

	@Autowired
	private VoitureRepository voitureRepository;
	
	
	@Override
	public Equipement AjouterEquipement(Equipement E) {
		return equipementRepository.save(E);
	}

	@Override
	public void SupprimerEquipement(Long id_equipement) {
		Equipement E = ChercherEquipement(id_equipement);
		for(Voiture v : E.getVoitures()) {
			v.getEquipements().remove(E);
		}
	    equipementRepository.deleteById(id_equipement);
	}

	@Override
	public Equipement ModifierEquipemet(Equipement E) {
		return equipementRepository.save(E);
	}

	@Override
	public List<Equipement> ListEquipment() {
		return equipementRepository.findAll();
	}

	@Override
	public Equipement ChercherEquipement(Long id_equipement) {
		return equipementRepository.findById(id_equipement).orElse(null);
	}

}
