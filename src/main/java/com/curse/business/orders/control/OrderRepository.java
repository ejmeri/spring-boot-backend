package com.curse.business.orders.control;

import com.curse.business.orders.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
