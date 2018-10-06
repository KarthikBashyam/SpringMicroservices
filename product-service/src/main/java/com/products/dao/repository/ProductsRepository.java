package com.products.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.entity.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
