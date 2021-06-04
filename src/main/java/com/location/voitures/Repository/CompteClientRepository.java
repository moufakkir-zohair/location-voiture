package com.location.voitures.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.location.voitures.Entity.CompteClient;

@Repository
public interface CompteClientRepository extends JpaRepository<CompteClient, Long> {
	 
}
