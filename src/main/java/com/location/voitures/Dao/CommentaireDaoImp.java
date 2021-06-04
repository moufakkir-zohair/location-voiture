package com.location.voitures.Dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Voiture;
import com.location.voitures.Repository.CommentaireRepository;


@Service
public class CommentaireDaoImp implements ICommentaireDao {
    
	@Autowired
	private CommentaireRepository commentaireRepository;
	
	
	@Override
	public Commentaire AjouterCommentaire(Commentaire C) {
		return commentaireRepository.save(C);
	}

	@Override
	public Commentaire ChercherCommentaire(Long id_commentaire) {
		return commentaireRepository.findById(id_commentaire).orElse(null);
	}

	@Override
	public Commentaire ModifierCommentaire(Commentaire C) {
		return commentaireRepository.save(C);
	}

	@Override
	public void SupprimerCommentaire(Long id_commentaire) {
		commentaireRepository.deleteById(id_commentaire);
	}

}
