package org.aadi.aop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.aadi.aop.model.Product;
import org.aadi.aop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@PostConstruct
	public void initDB() {
		repository.saveAll(Stream.of(new Product(101, "Book", 499), new Product(102, "laptop", 78000))
				.collect(Collectors.toList()));
	}

	public List<Product> addProduct(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> findAllProducts() {
		return repository.findAll();
	}

	public Product findProductById(int id) {	
		return repository.findById(id).get();
	}

}