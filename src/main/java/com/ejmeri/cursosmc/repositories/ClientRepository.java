package com.ejmeri.cursosmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmeri.cursosmc.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
