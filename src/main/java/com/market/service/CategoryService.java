package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.exceptions.InvalidCategoryException;
import com.market.model.Category;
import com.market.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public void create(Category category) {
		if(!category.equals(null)) {
			Category savedCategory = categoryRepository.save(category);
			if(savedCategory != category) {
				throw new InvalidCategoryException("Erro ao salvar a categoria!");
			}
		} else {
			throw new InvalidCategoryException("Categoria nula ou invalida!");
		}
		
	}

}
