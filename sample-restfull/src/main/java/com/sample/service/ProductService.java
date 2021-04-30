package com.sample.service;

import java.util.List;

import com.sample.dto.ProductDto;
import com.sample.exception.BusinessException;

/**
 * 
 * @author Israe I. Rodriguez E.
 *
 */
public interface ProductService {

	/**
	 * Se guarda producto
	 */
	ProductDto save(ProductDto product) throws BusinessException;

	/**
	 * Se obtiene un producto por id
	 */
	ProductDto get(String id) throws BusinessException;

	/**
	 * Se obtienen todos los productos
	 * 
	 */
	List<ProductDto> get() throws BusinessException;

	/**
	 * 
	 * Se actualiza un producto
	 */
	ProductDto update(ProductDto product) throws BusinessException;

	/**
	 * Se elimina un producto por id
	 */
	void delete(String id) throws BusinessException;
}
