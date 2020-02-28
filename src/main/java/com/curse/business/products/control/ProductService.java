package com.curse.business.products.control;

import java.util.List;

import com.curse.business.categories.control.CategoryService;
import com.curse.business.categories.entity.Category;
import com.curse.business.products.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	CategoryService categoryService;

	public Product findById(final Integer id) {
		return productRepository.findById(id).orElse(null);
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Page<Product> search(String name, List<Integer> ids, Integer page, Integer size, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		List<Category> categories = this.categoryService.findAllById(ids);

		return this.productRepository.findByNameAndCategoriesIn(name, categories, pageRequest);
	}
}
