package com.ejmeri.cursosmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmeri.cursosmc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
