package com.ejmeri.cursosmc.repositories;

import com.ejmeri.cursosmc.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
