package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.NullProductException;
import com.market.model.Product;
import com.market.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void create(Product product) {
		Product savedProduct = productRepository.save(product);
		
		if(savedProduct.equals(null)) {
			throw new NullProductException("Erro ao salvar o produto!");
		}
	}
	
	
}
