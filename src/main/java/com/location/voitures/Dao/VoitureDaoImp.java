package com.location.voitures.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Equipement;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;
import com.location.voitures.Repository.VoitureRepository;

@Transactional
@Service
public class VoitureDaoImp implements IVoitureDao {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private IEquipementDao equipementDaoImp;
	
	
	@Override
	public Voiture AjouterVoiture(Voiture V) {
		return voitureRepository.save(V);
	}

	@Override
	public Voiture ModifierVoiture(Voiture V) {
		return voitureRepository.save(V);
	}

	@Override
	public void SupprimerVoiture(Long id_voiture) {
		 voitureRepository.deleteById(id_voiture);
	}

	
	@Override
	public Voiture ChercherVoiture(Long id_voiture) {
		return voitureRepository.findById(id_voiture).orElse(null);
	}

	@Override
	public List<Equipement> ListeEquipementVoiture(Long id_voiture) {
		Voiture V = ChercherVoiture(id_voiture);
		return V.getEquipements();
	}

	@Override
	public List<Commentaire> ListCommentaireVoiture(Long id_voiture) {
		Voiture V = ChercherVoiture(id_voiture);
		return V.getCommentaires();
	}

	@Override
	public List<Location> ListLocationVoiture(Long id_voiture) {
		Voiture V = ChercherVoiture(id_voiture);
		return V.getLocations();
	}

	@Override
	public List<Voiture> ListVoiture() {
		return voitureRepository.findAll();
	}

	@Override
	public void AffecterEquipement(Long id_equipement, Long id_voiture) {
		Voiture V = ChercherVoiture(id_voiture);
		Equipement E = equipementDaoImp.ChercherEquipement(id_equipement);
	
		if(E!=null)
		if(!V.getEquipements().contains(E))
		    V.getEquipements().add(E);
		
	}

}
