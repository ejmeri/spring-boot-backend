package com.ejmeri.cursosmc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejmeri.cursosmc.domain.Product;
import com.ejmeri.cursosmc.repositories.ProductRepository;

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
