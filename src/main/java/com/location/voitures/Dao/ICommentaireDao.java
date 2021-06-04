package com.location.voitures.Dao;

import java.util.List;

import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Voiture;

public interface ICommentaireDao {
	
   public Commentaire AjouterCommentaire(Commentaire C);
   public Commentaire ModifierCommentaire(Commentaire C);
   public void SupprimerCommentaire(Long id_commentaire);
   public Commentaire ChercherCommentaire(Long id_commentaire);
   
}
