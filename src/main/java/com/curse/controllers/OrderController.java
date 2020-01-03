package com.curse.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curse.business.orders.control.OrderService;
import com.curse.business.orders.entity.Order;
@RestController
@RequestMapping(value="/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Order order = this.orderService.findbyId(id);
		return ResponseEntity.ok().body(order);
	}
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Order> categories = this.orderService.findAll();
		return ResponseEntity.ok(categories);
	}
}
