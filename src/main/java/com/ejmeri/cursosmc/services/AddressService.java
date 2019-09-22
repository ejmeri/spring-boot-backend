package com.ejmeri.cursosmc.services;


import java.util.List;

import com.ejmeri.cursosmc.domain.Address;
import com.ejmeri.cursosmc.repositories.AddressRepository;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address findbyId(Integer id) {
		Address address = addressRepository.findById(id).orElse(null);

		if (address == null) {
			throw new ObjectNotFoundException("Endereço não encontrado!");
		}

		return address;
	}
	
	public List<Address> findAll() {
		return this.addressRepository.findAll();
	}
}
