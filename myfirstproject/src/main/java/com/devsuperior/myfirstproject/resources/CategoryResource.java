package com.devsuperior.myfirstproject.resources;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
		@Autowired
		private CategoryRepository categoryRepository;
	
		@GetMapping
		public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();	
			
//		List<Category> list = new ArrayList<>();
//		list.add(new Category(1L, "Eletronics"));
//		list.add(new Category(2L, "Books"));
		
		return ResponseEntity.ok().body(list);
		
//		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		
//		Category cat = new Category(1L, "Eletronics");
		
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}
