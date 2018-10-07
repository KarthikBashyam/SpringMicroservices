package com.orders.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
