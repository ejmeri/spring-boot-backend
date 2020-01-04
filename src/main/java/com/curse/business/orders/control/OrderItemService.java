package com.curse.business.orders.control;


import java.util.List;
import java.util.Set;

import com.curse.business.orders.entity.OrderItem;
import com.curse.shared.exceptions.ObjectNotFoundException;
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

	public void saveAll(Set<OrderItem> items) {
		this.orderItemRepository.saveAll(items);
	}
}
