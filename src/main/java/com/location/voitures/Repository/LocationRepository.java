package com.location.voitures.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.voitures.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
