package com.ejmeri.cursosmc.services;


import java.util.List;

import com.ejmeri.cursosmc.domain.Client;
import com.ejmeri.cursosmc.repositories.ClientRepository;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client findbyId(Integer id) {
		Client  client = clientRepository.findById(id).orElse(null);

		if (client == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}

		return client;
	}
	
	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}
}
