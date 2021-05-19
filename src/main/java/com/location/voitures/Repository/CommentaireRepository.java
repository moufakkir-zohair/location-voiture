package com.location.voitures.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.location.voitures.Entity.Commentaire;
import com.location.voitures.Entity.Voiture;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

	public List<Commentaire> findByVoiture(Voiture V);

}
