package com.location.voitures.Controllers;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.location.voitures.Dao.ICommentaireDao;
import com.location.voitures.Dao.ICompteDao;
import com.location.voitures.Dao.IVoitureDao;
import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.CompteClient;
import com.location.voitures.Entity.Voiture;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

	
	@Autowired
	private ICommentaireDao commentaireDaoImp;
	
	@Autowired
	private IVoitureDao voitureDaoImpl;
	
	@Autowired
	private ICompteDao compteDaoImpl;
	
	
	@PostMapping("/ajouter")
	@ApiOperation(value = "Ajouter un commentaire",
	              notes="vous devez specifier l'ID de voiture, l'ID de client et le commentaire")
	public ResponseEntity<Commentaire> AjouterCommentaire(@ApiParam(value = "ID de voiture",required = true)   @RequestParam Long id_voiture , @ApiParam(value = "ID de client",required = true) @RequestParam Long id_client, @ApiParam(value = "le commentaire",required = true)  @RequestParam String commentaire){
		Voiture V = voitureDaoImpl.ChercherVoiture(id_voiture);
		CompteClient CC = (CompteClient) compteDaoImpl.ChercherCompte(id_client);
		Commentaire C = commentaireDaoImp.AjouterCommentaire(new Commentaire(commentaire, new Date(), V, CC));
		return new ResponseEntity<>(C,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/modifier")
	
	@ApiOperation(value = "Modifier un commentaire",
    notes="vous devez specifier l'ID de commentaire, et le nouveau commentaire")
	
	public ResponseEntity<Commentaire> ModifierVoiture(@ApiParam(value = "ID de commentaire",required = true) @RequestParam Long id_commentaire, @ApiParam(value = "nouveau commentaire",required = true)  @RequestParam String commentaire){
		Commentaire C = commentaireDaoImp.ChercherCommentaire(id_commentaire);
		C.setCommentaire(commentaire);
		commentaireDaoImp.ModifierCommentaire(C);
		return new ResponseEntity<>(C,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/supprimer/{id}")
	@ApiOperation(value = "Supprimer un commentaire",
    notes="vous devez specifier l'ID de commentaire")
	public ResponseEntity<?> SupprimerCommentaire(@ApiParam(value = "ID de commentaire",required = true) @PathVariable("id") Long id){
		commentaireDaoImp.SupprimerCommentaire(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
