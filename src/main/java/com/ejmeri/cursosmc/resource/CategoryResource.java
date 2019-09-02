package com.ejmeri.cursosmc.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejmeri.cursosmc.domain.Category;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> list() {
		Category c1 = new Category(1, "Informática");
		Category c2 = new Category(2, "Roupas");
		
		List<Category> catogories = new ArrayList<>();
		
		catogories.add(c1);
		catogories.add(c2);
		
		return catogories;
	}
}
