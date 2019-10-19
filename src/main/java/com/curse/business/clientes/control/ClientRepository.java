package com.curse.business.clientes.control;

import com.curse.business.clientes.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface ClientRepository extends JpaRepository<Client, Integer> {
	
}
