package com.market.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.exceptions.NullProductException;
import com.market.model.Category;
import com.market.model.Product;
import com.market.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryRest {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		
		try {
			categoryService.create(category);
		} catch (NullProductException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso!");
	}
}
