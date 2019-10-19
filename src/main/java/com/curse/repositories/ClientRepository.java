package com.curse.repositories;

import com.curse.business.clientes.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "ClientMainRepository")
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
