package com.ejmeri.cursosmc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejmeri.cursosmc.domain.Client;
import com.ejmeri.cursosmc.services.ClientService;

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
}
