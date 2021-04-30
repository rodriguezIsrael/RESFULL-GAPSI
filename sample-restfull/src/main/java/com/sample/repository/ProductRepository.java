package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Product;

/**
 * Repositorio para productos
 * 
 * @author Israel I. Rodriguez Espinoza.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
