package com.ejmeri.cursosmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import com.ejmeri.cursosmc.domain.Category;
import com.ejmeri.cursosmc.repositories.CategoryRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category one = new Category(null, "Informática");
		Category two = new Category(null, "Escritório");
		
		this.categoryRepository.saveAll(Arrays.asList(one, two));
	}
	

}
