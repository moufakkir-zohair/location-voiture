package com.location.voitures.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.voitures.Entity.Location;
import com.location.voitures.Entity.Voiture;

public interface LocationRepository extends JpaRepository<Location, Long>{

	@Query("select count(*) from Location where (?2 between date_debut and date_fin) and voiture = ?1 ")
	int countLocationDate(Voiture v, Date date);

}
