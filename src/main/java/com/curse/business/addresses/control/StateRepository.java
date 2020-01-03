package com.curse.business.addresses.control;

import com.curse.business.addresses.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
}
