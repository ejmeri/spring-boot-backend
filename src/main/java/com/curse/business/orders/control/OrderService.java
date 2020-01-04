package com.curse.business.orders.control;


import java.util.List;

import com.curse.business.orders.entity.Order;
import com.curse.shared.exceptions.ObjectNotFoundException;

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

	public Order save(Order order) {
		return this.orderRepository.save(order);
	}
}
