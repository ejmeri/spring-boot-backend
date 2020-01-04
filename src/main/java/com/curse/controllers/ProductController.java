package com.curse.controllers;

import java.util.List;

import com.curse.business.products.control.ProductService;
import com.curse.business.products.entity.Product;
import com.curse.business.products.entity.ProductDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController  {
    
    @Autowired
    private ProductService productService;
    
    
    @GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Product order = this.productService.findById(id);
		return ResponseEntity.ok().body(order);
    }
    

    @GetMapping("page")
	public ResponseEntity<Page<ProductDTO>> findByPage(@RequestParam("name") String name, @RequestParam("categories") List<Integer> categoriesIds,   @RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size) {
		Page<Product> products = this.productService.search(name, categoriesIds, page, size, "name", "ASC");
		Page<ProductDTO> productModels = products.map(obj -> new ProductDTO(obj));

		return ResponseEntity.ok().body(productModels);
	}

}