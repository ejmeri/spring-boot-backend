package com.ejmeri.cursosmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmeri.cursosmc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
}
