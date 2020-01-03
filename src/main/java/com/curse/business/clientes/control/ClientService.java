package com.curse.business.clientes.control;

import java.util.List;

import com.curse.business.addresses.control.AddressService;
import com.curse.business.addresses.entity.Address;
import com.curse.business.addresses.entity.City;
import com.curse.business.clientes.dto.ClientDTO;
import com.curse.business.clientes.dto.ClientNewDto;
import com.curse.business.clientes.entity.Client;
import com.curse.business.clientes.enums.ClientType;
import com.curse.shared.exceptions.DataIntegrationException;
import com.curse.shared.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressService addressService;

public List<Client> findAll() {
		return this.clientRepository.findAll();
	}

	public Client findbyId(Integer id) {
		Client client = clientRepository.findById(id).orElse(null);

		if (client == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}

		return client;
	}

	public Client save(Client client) {
		client.setId(null);
		client = this.clientRepository.save(client);
		this.addressService.saveAll(client.getAddresses());
		return client;
	}

	public Client update(Integer id, Client client) {
		if (id == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}
		Client oldClient = this.findbyId(id);
		this.updateClient(oldClient, client);

		return this.clientRepository.save(oldClient);
	}

	private void updateClient(Client oldClient, Client client) {
		oldClient.setName(client.getName());
		oldClient.setEmail(client.getEmail());
	}

	public void delete(Integer id) {
		if (id == null) {
			throw new ObjectNotFoundException("Cliente não encontrado!");
		}

		try {
			this.clientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrationException("Não é possível excluir uma cliente que possui pedidos!");
		} catch (Exception e) {
			throw new ObjectNotFoundException("Erro ao deletar cliente! -> " + e.getMessage());
		}
	}

	public Page<Client> findPage(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return this.clientRepository.findAll(pageRequest);

	}

	public Client fromDto(ClientDTO clientDto) {
		return new Client( clientDto.getId(), clientDto.getEmail(), clientDto.getName(), null, null);
	}

	public Client fromDto(ClientNewDto clientDto) {
		Client client = new Client(null, clientDto.getEmail(), clientDto.getName(), clientDto.getDocument(), ClientType.toEnum(clientDto.getType()));
		City city = new City(clientDto.getCityId(), null, null);
		Address address = new Address(null, clientDto.getStreet(), clientDto.getNumber(), clientDto.getComplement(), clientDto.getNeighborhood(), clientDto.getZipcode(), client, city);
		client.getAddresses().add(address);
		client.getTelephones().addAll(clientDto.getTelephones());

		return client;
	}
}
