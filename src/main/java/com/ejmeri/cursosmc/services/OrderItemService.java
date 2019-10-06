package com.ejmeri.cursosmc.services;


import java.util.List;

import com.ejmeri.cursosmc.domain.Order;
import com.ejmeri.cursosmc.domain.OrderItem;
import com.ejmeri.cursosmc.repositories.OrderItemRepository;
import com.ejmeri.cursosmc.repositories.OrderRepository;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderItem findbyId(Integer id) {
		OrderItem order = orderItemRepository.findById(id).orElse(null);

		if (order == null) {
			throw new ObjectNotFoundException("Item do Pedido não encontrado!");
		}

		return order;
	}
	
	public List<OrderItem> findAll() {
		return this.orderItemRepository.findAll();
	}
}
