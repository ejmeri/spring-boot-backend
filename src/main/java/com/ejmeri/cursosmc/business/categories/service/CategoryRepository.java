package com.ejmeri.cursosmc.business.categories.service;

import com.ejmeri.cursosmc.business.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
