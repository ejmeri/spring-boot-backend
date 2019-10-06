package com.curse.services;


import java.util.List;

import com.curse.domain.City;
import com.curse.repositories.CityRepository;
import com.curse.services.exceptions.ObjectNotFoundException;

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
