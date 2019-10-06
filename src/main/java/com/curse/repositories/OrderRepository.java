package com.curse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curse.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
