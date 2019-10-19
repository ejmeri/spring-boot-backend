package com.curse.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.curse.business.categories.dto.CategoryDTO;
import com.curse.business.categories.entity.Category;
import com.curse.business.categories.control.CategoryService;

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
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> categories = this.categoryService.findAll();
		List<CategoryDTO> categoryModels = categories.stream().map(obj -> new CategoryDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(categoryModels);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) {
		Category category = this.categoryService.findbyId(id);
		CategoryDTO categoryModels = new CategoryDTO(category);
		return ResponseEntity.ok().body(categoryModels);
	}

	@PostMapping()
	public ResponseEntity<Void> save(@Valid @RequestBody CategoryDTO categoryDto) {
		Category category = this.categoryService.fromDto(categoryDto);
		category = this.categoryService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Integer id, @Valid @RequestBody CategoryDTO categoryDTO) {
		Category category = this.categoryService.fromDto(categoryDTO);
		this.categoryService.update(id, category);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		this.categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("page")
	public ResponseEntity<Page<CategoryDTO>> findByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size) {
		Page<Category> categories = this.categoryService.findPage(page, size, "name", "ASC");
		Page<CategoryDTO> categoryModels = categories.map(obj -> new CategoryDTO(obj));

		return ResponseEntity.ok().body(categoryModels);
	}
}
