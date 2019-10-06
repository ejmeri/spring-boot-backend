package com.curse.business.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curse.business.categories.entity.Category;
import com.curse.business.categories.service.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Category category = this.categoryService.findbyId(id);
		return ResponseEntity.ok().body(category);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Category> categories = this.categoryService.findAll();
		return ResponseEntity.ok(categories);
	}

	@PostMapping()
	public ResponseEntity<Category> save(@RequestBody Category category) {
		category = this.categoryService.save(category);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).build(); 
	}
}
