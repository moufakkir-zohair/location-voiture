package com.location.voitures.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;
import com.location.voitures.Repository.LocationRepository;
import com.location.voitures.Repository.VoitureRepository;


@Service
public class LocationDaoImp implements ILocationDao {

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private VoitureRepository voitureRepository;

	@Override
	public Location AjouterLocation(Location L) {
		return locationRepository.save(L);
	}

	@Override
	public void AccepterLocation(Long id_location) {
		Location L = ChercherLocation(id_location);
		L.setAcceptee(true);
		locationRepository.save(L);
	}

	@Override
	public void EffectuerLocation(Long id_location) {
	   Location L = ChercherLocation(id_location);
	   L.setEffectuee(true);
	   locationRepository.save(L);
	}

	@Override
	public Location ChercherLocation(Long id_location) {
		return locationRepository.findById(id_location).orElse(null);
	}

	@Override
	public int VerifierLocation(Long id_voiture , Date date) {
		Voiture V = voitureRepository.findById(id_voiture).orElse(null);
		if(V != null) {
			return locationRepository.countLocationDate(V,date);
		}
		return -1;
	}

	@Override
	public List<Location> ListeLocation() {
		return locationRepository.findAll();
	}

	@Override
	public Voiture VoitureLocation(Long id_location) {
		Location L  = ChercherLocation(id_location);
		return L.getVoiture();
	}
	
}
