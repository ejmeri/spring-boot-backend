package com.ejmeri.cursosmc.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejmeri.cursosmc.domain.Category;
import com.ejmeri.cursosmc.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findbyId(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
}
