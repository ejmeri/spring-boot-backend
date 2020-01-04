package com.curse.business.categories.control;

import java.util.List;

import com.curse.business.categories.dto.CategoryDTO;
import com.curse.business.categories.entity.Category;
import com.curse.shared.exceptions.DataIntegrationException;
import com.curse.shared.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	public Category findbyId(Integer id) {
		Category category = categoryRepository.findById(id).orElse(null);

		if (category == null) {
			throw new ObjectNotFoundException("Categoria não encontrada!");
		}

		return category;
	}

	public Category save(Category category) {
		return this.categoryRepository.save(category);
	}

	public Category update(Integer id, Category category) {
		if (id == null) {
			throw new ObjectNotFoundException("Categoria não encontrada!");
		}
		Category oldCategory = this.findbyId(id);
		if (oldCategory == null) {
			throw new ObjectNotFoundException("Categoria não encontrada!");
		}
		oldCategory.setName((category.getName()));
		return this.categoryRepository.save(oldCategory);
	}

	public void delete(Integer id) {
		if (id == null) {
			throw new ObjectNotFoundException("Categoria não encontrada!");
		}

		try {
			this.categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrationException("Não é possível excluir uma categoria que possui produtos!");
		} catch (Exception e) {
			throw new ObjectNotFoundException("Erro ao deletar categoria! -> " + e.getMessage());
		}
	}

	public Page<Category> findPage(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return this.categoryRepository.findAll(pageRequest);

	}

	public Category fromDto(CategoryDTO categoryDTO) {
		return new Category(categoryDTO.getId(), categoryDTO.getName());
	}

	public List<Category> findAllById(List<Integer> ids) {
		return this.categoryRepository.findAllById(ids);
	}
}
