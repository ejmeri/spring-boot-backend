package com.curse.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.curse.business.clientes.control.ClientService;
import com.curse.business.clientes.dto.ClientDTO;
import com.curse.business.clientes.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Client client = this.clientService.findbyId(id);
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Client> clients = this.clientService.findAll();
		return ResponseEntity.ok(clients);
	}

	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody ClientDTO clientDto) {
		Client client = this.clientService.fromDto(clientDto);
		client = this.clientService.save(client);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(client.getId())
				.toUri();
		return ResponseEntity.created(uri).build(); 
	}
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Integer id,@Valid @RequestBody ClientDTO clientDTO) {
		Client client = this.clientService.fromDto(clientDTO);
		this.clientService.update(id, client);
		return ResponseEntity.noContent().build(); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		this.clientService.delete(id);
		return ResponseEntity.noContent().build(); 
	}

	@GetMapping("page")
	public ResponseEntity<Page<ClientDTO>> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "24") Integer size) {
		Page<Client> categories = this.clientService.findPage(page, size, "name", "ASC");
		Page<ClientDTO> clientModels = categories.map(obj -> new ClientDTO(obj));
						
		return ResponseEntity.ok().body(clientModels);
	}
}
