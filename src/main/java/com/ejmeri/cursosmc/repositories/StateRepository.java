package com.ejmeri.cursosmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmeri.cursosmc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
}
