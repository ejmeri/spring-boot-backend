package com.ejmeri.cursosmc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.ejmeri.cursosmc.domain.Category;
import com.ejmeri.cursosmc.domain.City;
import com.ejmeri.cursosmc.domain.Product;
import com.ejmeri.cursosmc.domain.State;
import com.ejmeri.cursosmc.repositories.CategoryRepository;
import com.ejmeri.cursosmc.repositories.CityRepository;
import com.ejmeri.cursosmc.repositories.ProductRepository;
import com.ejmeri.cursosmc.repositories.StateRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cone = new Category(null, "Informática");
		Category ctwo = new Category(null, "Escritório");

		Product pone = new Product(null, "Computador", 2500.0);
		Product ptwo = new Product(null, "Impressora", 899.0);
		Product pthree = new Product(null, "Mouse", 99.0);	
		
		cone.getProducts().addAll(Arrays.asList(pone, ptwo, pthree));
		ctwo.getProducts().addAll(Arrays.asList(ptwo));

		pone.getCategories().addAll(Arrays.asList(cone));
		ptwo.getCategories().addAll(Arrays.asList(cone, ctwo));
		pthree.getCategories().addAll(Arrays.asList(cone));
		
		this.categoryRepository.saveAll(Arrays.asList(cone, ctwo));
		this.productRepository.saveAll(Arrays.asList(pone, ptwo, pthree));
		
		State stateOne = new State(null, "São Paulo");
		State stateTwo = new State(null, "Minas Gerais");
		
		City cityOne = new City(null, "São Paulo", stateOne);
		City cityTwo = new City(null, "Belo Horizonte", stateTwo);
		City cityThree = new City(null, "Campinas", stateOne);
		
		stateOne.getCities().addAll(Arrays.asList(cityOne, cityThree));
		stateTwo.getCities().addAll(Arrays.asList(cityTwo));
		
		this.stateRepository.saveAll(Arrays.asList(stateOne, stateTwo));
		this.cityRepository.saveAll(Arrays.asList(cityOne, cityTwo, cityThree));
				
	}
	

}
