package com.market.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByUuid(UUID uuid);
	
	@Transactional
    @Query("SELECT p FROM Product p where p.value = (SELECT new Product MAX(p.value) FROM Product p)")
    Product getMostExpansive();
}
