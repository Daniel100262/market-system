package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.market.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Transactional
    @Query("SELECT c FROM Category c where c.name = :name")
    Category getCategoryByName(String name);
}
