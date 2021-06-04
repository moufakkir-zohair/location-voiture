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
import org.springframework.web.bind.annotation.RestController;
import com.location.voitures.Dao.IEquipementDao;
import com.location.voitures.Entity.Equipement;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/equipements")
public class EquipementController {
	
	
	@Autowired
	private IEquipementDao equipementDaoImp;
	
	
	@GetMapping("/liste")
	@ApiOperation(value = "Liste des equipements ",
    notes="rien comme parametere ")
	public ResponseEntity<List<Equipement>> ListeEquipement(){
		List<Equipement> equipements = equipementDaoImp.ListEquipment();
		return new ResponseEntity<>(equipements,HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajouter un equipement ",
    notes="vous  devez specifier l'objet equipement ")
	public ResponseEntity<Equipement> AjouterEquipement( @ApiParam(value = "Equipement",required = true) @RequestBody Equipement equipement){
		Equipement eqpmt = equipementDaoImp.AjouterEquipement(equipement);
		return new ResponseEntity<>(eqpmt,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/modifier")
	@ApiOperation(value = "Modifier un equipement ",
    notes="vous  devez specifier l'objet equipement modifier avec ID sinion il sera cree ")
	public ResponseEntity<Equipement> ModifierVoiture( @ApiParam(value = "Equipement-modifier",required = true) @RequestBody Equipement equipement){
		Equipement eqpmt = equipementDaoImp.ModifierEquipemet(equipement);
		return new ResponseEntity<>(eqpmt,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer un equipement ",
    notes="vous devez specifier ID de  l'equipement a supprimer ")
	public ResponseEntity<?> SupprimerVoiture(@ApiParam(value = "ID equipement",required = true) @PathVariable("id") Long id){
		equipementDaoImp.SupprimerEquipement(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
