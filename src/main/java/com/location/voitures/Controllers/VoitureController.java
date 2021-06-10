package com.location.voitures.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.location.voitures.Dao.IVoitureDao;
import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Equipement;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/voitures")
public class VoitureController {

	@Autowired
	private IVoitureDao voitureDaoImp;
	
	@GetMapping("/liste")
	@ApiOperation(value = "Liste des voitures",
    notes="rien comme parametere")
	public ResponseEntity<List<Voiture>> ListeVoiture(){
		List<Voiture> v = voitureDaoImp.ListVoiture();
		return new ResponseEntity<>(v,HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajouter une voiture",
    notes="vous devez entrez l'objet voiture sous forme JSON sans id")
	public ResponseEntity<Voiture> AjouterVoiture(@ApiParam(value = "Objet voiture",required = true) @RequestBody Voiture voiture){
		Voiture V = voitureDaoImp.AjouterVoiture(voiture);
		return new ResponseEntity<>(V,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/modifier")
	@ApiOperation(value = "Modifier une voiture",
    notes="vous devez entrez l'objet voiture sous forme JSON avec id")
	public ResponseEntity<Voiture> ModifierVoiture(@ApiParam(value = "Objet voiture",required = true) @RequestBody Voiture voiture){
		Voiture V = voitureDaoImp.ModifierVoiture(voiture);
		System.out.println("modifier voiture ");
		return new ResponseEntity<>(V,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer une voiture",
    notes="vous devez specifier l'id de voiture a supprimer")
	public ResponseEntity<?> SupprimerVoiture(@ApiParam(value = "ID voiture",required = true) @PathVariable("id") Long id){
		voitureDaoImp.SupprimerVoiture(id);
		System.out.println("supprimer voiture");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/equipements/{id}")
	@ApiOperation(value = "Liste des equipements d'une voiture",
    notes="vous devez specifier l'id de voiture")
	public ResponseEntity<List<Equipement>> ListeEquipement(@ApiParam(value = "ID voiture",required = true) @PathVariable("id") Long id){
		List<Equipement> equipements = voitureDaoImp.ListeEquipementVoiture(id);
		return new ResponseEntity<>(equipements,HttpStatus.OK);
	}
	
	@GetMapping("/commentaires/{id}")
	@ApiOperation(value = "Liste des commentaires d'une voiture",
    notes="vous devez specifier l'id de voiture")
	public ResponseEntity<List<Commentaire>> ListeCommentaire(@ApiParam(value = "ID voiture",required = true) @PathVariable("id") Long id){
		List<Commentaire> commentaires = voitureDaoImp.ListCommentaireVoiture(id);
		return new ResponseEntity<>(commentaires,HttpStatus.OK);
	}
	
	@GetMapping("/locations/{id}")
	@ApiOperation(value = "Liste des locations d'une voiture",
    notes="vous devez specifier l'id de voiture")
	public ResponseEntity<List<Location>> ListeLocation(@ApiParam(value = "ID voiture",required = true) @PathVariable("id") Long id){
		List<Location> locations = voitureDaoImp.ListLocationVoiture(id);
		return new ResponseEntity<>(locations,HttpStatus.OK);
	}
	
	@PostMapping("/affecterEqui")
	@ApiOperation(value = "Affecter un equipement a une voiture",
    notes="vous devez specifier l'id de voiture et l'id equipemet")
	public ResponseEntity<?> AffecterEquipement(@ApiParam(value = "ID voiture",required = true) @RequestParam Long id_voiture , @ApiParam(value = "ID equipemet",required = true) @RequestParam Long id_equipement){
		voitureDaoImp.AffecterEquipement(id_equipement, id_voiture);
		System.out.println("id_voiture= "+id_voiture);
		return new ResponseEntity<>(HttpStatus.OK);
	}
   
	
}
