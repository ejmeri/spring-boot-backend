package com.curse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curse.domain.Product;
import com.curse.repositories.ProductRepository;

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
