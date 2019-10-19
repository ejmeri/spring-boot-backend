package com.curse.business.clientes.control;

import java.util.List;

import javax.validation.Valid;

import com.curse.business.clientes.dto.ClientDTO;
import com.curse.business.clientes.entity.Client;
import com.curse.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client findbyId(Integer id) {
		Client client = clientRepository.findById(id).orElse(null);

		if (client == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}

		return client;
	}

	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}

	public Client save(Client client) {
		return null;
	}

	public void update(Integer id, Client client) {
	}

	public void delete(Integer id) {
	}

	public Page<Client> findPage(Integer page, Integer size, String string, String string2) {
		return null;
	}

	public Client fromDto(@Valid ClientDTO clientDto) {
		return null;
	}
}
