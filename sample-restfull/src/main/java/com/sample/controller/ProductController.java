package com.sample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.ProductDto;
import com.sample.exception.BusinessException;
import com.sample.service.ProductService;

/**
 * 
 * @author Israel I. Rodriguez Espinoza.
 */
@RequestMapping("/products")
@RestController
public class ProductController {

	@Autowired
	private ProductService productsService;

	@GetMapping
	public ResponseEntity<Object> get(@RequestParam(name = "id", required = false) String id) throws BusinessException {
		if (id == null) {
			return new ResponseEntity<Object>(productsService.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Object>(productsService.get(id), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid ProductDto productDto) throws BusinessException {

		return new ResponseEntity<Object>(productsService.save(productDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid ProductDto productDto) throws BusinessException {

		return new ResponseEntity<Object>(productsService.update(productDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) throws BusinessException {
		productsService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
