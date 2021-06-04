package com.location.voitures.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.voitures.Dao.ILocationDao;
import com.location.voitures.Dao.LocationDaoImp;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private ILocationDao locationDaoImp;
	
	@GetMapping("/liste")
	public ResponseEntity<List<Location>> ListeLocation(){
		List<Location> L = locationDaoImp.ListeLocation();
		return new ResponseEntity<>(L,HttpStatus.OK);
	}
	
	
	@GetMapping("/voiture/{id}")
	public ResponseEntity<Voiture> VoitureLocation(@PathVariable("id") Long id){
		Voiture V = locationDaoImp.VoitureLocation(id);
		return new ResponseEntity<>(V,HttpStatus.OK);
	}
	
	@GetMapping("/accepter/{id}")
	public ResponseEntity<?> AccepterLocation(@PathVariable("id") Long id){
		 locationDaoImp.AccepterLocation(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/effectuer/{id}")
	public ResponseEntity<?> EffectuerLocation(@PathVariable("id") Long id){
		 locationDaoImp.EffectuerLocation(id);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/disponible/{id}")
	public ResponseEntity<Integer> DisponibleLocation(@PathVariable("id") Long id){
		 Integer nbre = locationDaoImp.VerifierLocation(id,new Date());
		 return new ResponseEntity<>(nbre,HttpStatus.OK);
	}
	
	
	
}
