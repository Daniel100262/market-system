package com.market.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.exceptions.NullProductException;
import com.market.model.Product;
import com.market.model.transport.ProductDTO;
import com.market.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRest {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addResident(@RequestBody Product product) {
		
		try {
			productService.create(product);
		} catch (NullProductException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso!");
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id){
		
		try {
			productService.delete(id);
		} catch (NullProductException e) {
			ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Produto deletado com sucesso!");
	}
	
	@GetMapping("/list-all")
	public List<ProductDTO> listAllProducts() {
		return productService.listAll();
	}
	
	
}
