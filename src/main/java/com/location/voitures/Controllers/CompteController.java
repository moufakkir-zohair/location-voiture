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

import com.location.voitures.Dao.ICompteDao;
import com.location.voitures.Entity.Compte;
import com.location.voitures.Entity.CompteAdmin;
import com.location.voitures.Entity.CompteClient;
import com.location.voitures.Entity.CompteManager;
import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/comptes")
public class CompteController {

	@Autowired
	private ICompteDao compteDaoImpl;
	
	@GetMapping("/listeCC")
	@ApiOperation(value = "Liste des compte client",
    notes="rien comme parametere")
	public ResponseEntity<List<CompteClient>> ListeCompteClient(){
		System.out.println("dddddddd");
		List<CompteClient> CC = compteDaoImpl.ListeCompteClient();
		return new ResponseEntity<>(CC,HttpStatus.OK);
	}
	
	@GetMapping("/listeCM")
	@ApiOperation(value = "Liste des comptes manager",
    notes="rien comme parametere")
	public ResponseEntity<List<CompteManager>> ListeCompteManager(){
		List<CompteManager> CM = compteDaoImpl.ListeCompteManager();
		return new ResponseEntity<>(CM,HttpStatus.OK);
	}
	
	@PostMapping("/ajouterCC")
	@ApiOperation(value = "Ajouter un compte client",
    notes="vous devez specifier toutes les champs de compte client")
	public ResponseEntity<CompteClient> AjouterCompteC(@ApiParam(value = "Compte client",required = true) @RequestBody CompteClient CC){
		compteDaoImpl.AjouterCompte(CC);
		return new ResponseEntity<>(CC,HttpStatus.CREATED);
	}
	
	@PostMapping("/ajouterCM")
	@ApiOperation(value = "Ajouter un compte manager",
    notes="vous devez specifier toutes les champs de compte manager")
	public ResponseEntity<CompteManager> AjouterCompteM(@ApiParam(value = "Compte manager",required = true) @RequestBody CompteManager CM){
		compteDaoImpl.AjouterCompte(CM);
		return new ResponseEntity<>(CM,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer un compte",
    notes="vous devez specifier le ID de  compte")
	public ResponseEntity<?> SupprimerCompte(@ApiParam(value = "ID de compte",required = true) @PathVariable("id") Long id){
		compteDaoImpl.SupprimerCompte(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/modifierCC")
	@ApiOperation(value = "Modifier un compte client",
    notes="vous devez specifier le nouveau compte avec id pour etre modifier sinon il sera ajouter")
	public ResponseEntity<?> ModifierCC(@ApiParam(value = "le compte client",required = true) @RequestBody CompteClient CC){
		compteDaoImpl.ModifierCompte(CC);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/modifierCM")
	@ApiOperation(value = "Modifier un compte manager",
    notes="vous devez specifier le nouveau compte avec id pour etre modifier sinon il sera ajouter")
	public ResponseEntity<?> ModifierCM(@ApiParam(value = "le compte client",required = true) @RequestBody CompteManager CM){
		compteDaoImpl.ModifierCompte(CM);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@GetMapping("/verifier")
	@ApiOperation(value = "Verifier un compte ",
    notes="vous devez specifier l'email et le mot de passe")
	public ResponseEntity<Integer> VerifierCompte(@ApiParam(value = "l'email de l'utilisateur",required = true)  @RequestParam String email , @ApiParam(value = "le mot de passe de l'utilisateur",required = true) @RequestParam  String MDP){
	    Compte C = compteDaoImpl.VerifierCompte(email, MDP);
	    int type_compte = 0;
	    if(C==null) type_compte= -1;
	    else if(C instanceof CompteClient)  type_compte= 1;
	    else if(C instanceof CompteManager) type_compte=2;
	    else if(C instanceof CompteAdmin )  type_compte =3;
		return new ResponseEntity<>(type_compte,HttpStatus.OK);
	}
	
	
	@GetMapping("/chercher")
	@ApiOperation(value = "chercher un compte ",
    notes="vous devez specifier l'email et le mot de passe")
	public ResponseEntity<Compte> ChercherCompte(@ApiParam(value = "l'email de l'utilisateur",required = true)  @RequestParam String email , @ApiParam(value = "le mot de passe de l'utilisateur",required = true) @RequestParam  String MDP){
	    Compte C = compteDaoImpl.VerifierCompte(email, MDP);
		return new ResponseEntity<>(C,HttpStatus.OK);
	}
	
	@GetMapping("/locations/{id}")
	@ApiOperation(value = "les locations effectuer d'un utilisateur donnee par leur id ",
    notes="vous devez specifier l'ID de compte")
	public ResponseEntity<List<Location>> LocationCompte(@ApiParam(value = "ID de compte",required = true) @PathVariable("id") Long id){
		List<Location> L = compteDaoImpl.ListeLocationCompte(id);
		return new ResponseEntity<>(L,HttpStatus.OK);
	}
	
}
