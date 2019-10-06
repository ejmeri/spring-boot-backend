package com.curse.services;


import java.util.List;

import com.curse.domain.State;
import com.curse.repositories.StateRepository;
import com.curse.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public State findbyId(Integer id) {
		State state = stateRepository.findById(id).orElse(null);

		if (state == null) {
			throw new ObjectNotFoundException("Estado não encontrado!");
		}

		return state;
	}
	
	public List<State> findAll() {
		return this.stateRepository.findAll();
	}
}
