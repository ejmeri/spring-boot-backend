package com.curse.business.orders.control;

import java.util.Date;
import java.util.List;

import com.curse.business.orders.entity.Order;
import com.curse.business.orders.entity.OrderItem;
import com.curse.business.payments.control.BillPaymentService;
import com.curse.business.payments.control.PaymentService;
import com.curse.business.payments.entity.BillPayment;
import com.curse.business.payments.enums.StatusPayment;
import com.curse.business.products.control.ProductService;
import com.curse.shared.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BillPaymentService billPaymentService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderItemService orderItemService;

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
		order.setId(null);
		order.setCreatedAt(new Date());

		order.getPayment().setStatus(StatusPayment.PEDENTE);
		order.getPayment().setOrder(order);

		if (order.getPayment() instanceof BillPayment) {
			BillPayment billPayment = (BillPayment) order.getPayment();
			this.billPaymentService.setSevenDaysToDueDate(billPayment, order.getCreatedAt());
		}

		order = this.orderRepository.save(order);

		this.paymentService.save(order.getPayment());

		for (OrderItem orderItem : order.getItems()) {
			orderItem.setDiscount(0.0);
			orderItem.setPrice(this.productService.findById(orderItem.getProduct().getId()).getPrice());
			orderItem.setOrder(order);
		}

		this.orderItemService.saveAll(order.getItems());

		return order;

	}
}
