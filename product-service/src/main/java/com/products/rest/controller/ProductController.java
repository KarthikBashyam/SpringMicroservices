package com.products.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.products.dao.repository.ProductsRepository;
import com.products.entity.Product;

@RestController("/products")
public class ProductController {

	private ProductsRepository productsRepository;

	public List<Product> findAllProducts() {
		return this.productsRepository.findAll();
	}

	@Autowired
	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

}
