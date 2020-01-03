package com.curse.business.addresses.control;


import java.util.List;

import com.curse.business.addresses.entity.City;
import com.curse.shared.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	public City findbyId(Integer id) {
		City  city = cityRepository.findById(id).orElse(null);

		if (city == null) {
			throw new ObjectNotFoundException("Cidade não encontrada!");
		}

		return city;
	}
	
	public List<City> findAll() {
		return this.cityRepository.findAll();
	}
}
