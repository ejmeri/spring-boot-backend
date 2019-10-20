package com.curse.business.addresses.control;


import java.util.List;

import com.curse.business.addresses.entity.Address;
import com.curse.services.exceptions.ObjectNotFoundException;

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

	public List<Address> saveAll (List<Address> addresses) {
		return this.addressRepository.saveAll(addresses);
	} 
}
