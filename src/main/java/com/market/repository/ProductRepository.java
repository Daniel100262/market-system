package com.market.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByUuid(UUID uuid);
}
