package org.aadi.aop.repository;

import org.aadi.aop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
