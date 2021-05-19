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
	public List<Commentaire> ListeCommentaire(Voiture V) {
		return commentaireRepository.findByVoiture(V);
	}

	@Override
	public void ModifierCommentaire(Commentaire C) {
		commentaireRepository.save(C);
	}

	@Override
	public void SupprimerCommentaire(Commentaire C) {
		commentaireRepository.deleteById(C.getId_commentaire());
	}

	@Override
	public Commentaire ChercherCommentaire(Long id_commentaire) {
		return commentaireRepository.findById(id_commentaire).orElse(null);
	}

}
