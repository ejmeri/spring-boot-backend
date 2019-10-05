package com.ejmeri.cursosmc.services;


import java.util.List;

import com.ejmeri.cursosmc.domain.Payment;
import com.ejmeri.cursosmc.repositories.PaymentRepository;
import com.ejmeri.cursosmc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment findbyId(Integer id) {
		Payment payment = paymentRepository.findById(id).orElse(null);

		if (payment == null) {
			throw new ObjectNotFoundException("Pagamento não encontrado!");
		}

		return payment;
	}
	
	public List<Payment> findAll() {
		return this.paymentRepository.findAll();
	}
}
