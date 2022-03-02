package com.market.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.exceptions.NullProductException;
import com.market.model.Product;
import com.market.model.transport.ProductDTO;
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

	public void delete(Integer id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new NullProductException("O produto que você tentou remover não existe!");
		}
		
	}

	public List<ProductDTO> listAll() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<>();

		products.stream().forEach(product -> productsDTO.add(new ProductDTO(UUID.randomUUID(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory())));
		
		return productsDTO;
	}

	public void update(Integer id, Product product) {
		if(productRepository.existsById(id)) {
			productRepository.save(product);
		} else {
			throw new NullProductException("O produto que você tentou atualizar não existe!");
		}
	}
	
	
	
	
	
}
