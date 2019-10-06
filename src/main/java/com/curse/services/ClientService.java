package com.curse.services;


import java.util.List;

import com.curse.domain.Client;
import com.curse.repositories.ClientRepository;
import com.curse.services.exceptions.ObjectNotFoundException;

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
