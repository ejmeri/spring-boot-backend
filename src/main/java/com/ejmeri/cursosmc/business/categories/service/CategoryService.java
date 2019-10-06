package com.ejmeri.cursosmc.business.categories.service;

import java.util.List;
import com.ejmeri.cursosmc.business.categories.entity.Category;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category findbyId(Integer id) {
		Category category = categoryRepository.findById(id).orElse(null);

		if (category == null) {
			throw new ObjectNotFoundException("Categoria não encontrada!");
		}

		return category;
	}
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
}
