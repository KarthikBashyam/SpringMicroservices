package com.orders.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dao.repository.OrderRepository;
import com.orders.entity.Orders;
import com.orders.util.OrderConfiguration;

@RestController
public class OrderController {

	private OrderRepository orderRepository;

	private OrderConfiguration orderConfig;

	@GetMapping(path = "/orders/list")
	public List<Orders> findAllOrders() {
		return this.orderRepository.findAll();
	}

	@GetMapping(path = "/orders/version")
	public String version() {
		return orderConfig.getVersion();
	}

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Autowired
	public void setOrderConfig(OrderConfiguration orderConfig) {
		this.orderConfig = orderConfig;
	}

}
