package com.location.voitures.Dao;

import java.util.List;

import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Voiture;

public interface ICommentaireDao {
	
   public Commentaire AjouterCommentaire(Commentaire C);
   public List<Commentaire> ListeCommentaire(Voiture V);
   public void ModifierCommentaire(Commentaire C);
   public void SupprimerCommentaire(Commentaire C);
   public Commentaire ChercherCommentaire(Long id_commentaire);
   
}
