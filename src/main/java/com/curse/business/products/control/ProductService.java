package com.curse.business.products.control;

import java.util.List;

import com.curse.business.products.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product findbyId(Integer id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}
}
