package com.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curse.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
