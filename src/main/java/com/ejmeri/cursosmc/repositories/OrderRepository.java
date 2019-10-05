package com.ejmeri.cursosmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejmeri.cursosmc.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
