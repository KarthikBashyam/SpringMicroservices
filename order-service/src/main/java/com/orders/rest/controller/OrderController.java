package com.orders.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dao.repository.OrderRepository;
import com.orders.entity.Orders;

@RestController
public class OrderController {

	private OrderRepository orderRepository;

	@GetMapping(path = "/orders/list")
	public List<Orders> findAllOrders() {
		return this.orderRepository.findAll();
	}

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

}
