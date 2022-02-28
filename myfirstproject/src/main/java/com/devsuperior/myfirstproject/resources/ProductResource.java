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

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
		@Autowired
		private ProductRepository ProductRepository;
	
		@GetMapping
		public ResponseEntity<List<Product>> findAll() {
		List<Product> list = ProductRepository.findAll();	
			
//		List<Product> list = new ArrayList<>();
//		list.add(new Product(1L, "Eletronics"));
//		list.add(new Product(2L, "Books"));
		
		return ResponseEntity.ok().body(list);
		
//		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		
//		Product cat = new Product(1L, "Eletronics");
		
		Product cat = ProductRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}
