package com.ejmeri.cursosmc.services;


import java.util.List;

import com.ejmeri.cursosmc.domain.Order;
import com.ejmeri.cursosmc.repositories.OrderRepository;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order findbyId(Integer id) {
		Order order = orderRepository.findById(id).orElse(null);

		if (order == null) {
			throw new ObjectNotFoundException("Pedido não encontrado!");
		}

		return order;
	}
	
	public List<Order> findAll() {
		return this.orderRepository.findAll();
	}
}
