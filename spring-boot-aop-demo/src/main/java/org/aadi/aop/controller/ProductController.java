package org.aadi.aop.controller;

import java.util.List;

import org.aadi.aop.model.Product;
import org.aadi.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public List<Product> saveProducts(@RequestBody List<Product> products) {

		List<Product> pList = service.addProduct(products);

		return pList;
	}

	@GetMapping("/findProducts")
	public List<Product> getAllProducts() {
		
		List<Product> products = service.findAllProducts();
	
		return products;
	}
	
	@GetMapping("/findProducts/{id}")
	public Product getProductById(@PathVariable int id) {
		
		Product product = service.findProductById(id);
	
		return product;
	}

}