package com.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curse.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
}
