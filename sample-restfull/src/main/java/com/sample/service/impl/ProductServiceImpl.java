package com.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dto.ProductDto;
import com.sample.entity.Product;
import com.sample.exception.BusinessException;
import com.sample.repository.ProductRepository;
import com.sample.service.ProductService;

/**
 * Clase de servicio para productos
 * 
 * @author isivr
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	@Transactional
	public ProductDto save(ProductDto productDto) throws BusinessException {
		LOG.info("--------- INICIO GUARDADO -----");

		Product productExist = productRepository.findById(productDto.getId()).orElse(null);

		if (productExist != null) {
			throw new BusinessException("El producto con el id: " + productDto.getId() + " ya existe");
		}

		LOG.info("Producto recibido: {}", productDto);
		Product product = new Product();

		product.setDescription(productDto.getDescription());
		product.setEnabled(Boolean.TRUE);
		product.setId(productDto.getId());
		product.setModel(productDto.getModel());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		productDto = parseProductToProductDto(productRepository.save(product));
		LOG.info("--------- FIN GUARDADO -----");
		return productDto;
	}

	@Override
	public ProductDto get(String id) throws BusinessException {

		Product product = productRepository.findById(id).orElse(null);

		if (product == null) {
			return new ProductDto();
		}

		return parseProductToProductDto(product);
	}

	@Override
	public ProductDto update(ProductDto productDto) throws BusinessException {
		LOG.info("--------- INICIO ACTUALIZACION -----");
		Product productToUpdate = productRepository.findById(productDto.getId()).orElse(null);
		if (productToUpdate == null) {
			LOG.error("No existe el producto con el id: {}", productDto.getId());

			throw new BusinessException("El producto que esta intentando actualizar no existe.");
		}

		productToUpdate.setDescription(productDto.getDescription());
		productToUpdate.setModel(productDto.getModel());

		productToUpdate = productRepository.save(productToUpdate);
		LOG.info("Datos actualizados: {}", productDto);

		LOG.info("--------- FIN ACTUALIZACION -----");
		return parseProductToProductDto(productToUpdate);
	}

	@Override
	public void delete(String id) throws BusinessException {
		LOG.info("--------- INICIO BORRADO LOGICO -----");

		Product productToDelete = productRepository.findById(id).orElse(null);
		if (productToDelete == null) {
			throw new BusinessException("El producto que esta intentando eliminar no existe.");
		}

		productToDelete.setEnabled(Boolean.FALSE);
		productRepository.save(productToDelete);
		LOG.info("Registro inhabilitado: {}", id);
		LOG.info("--------- FIN BORRADO LOGICO -----");
	}

	@Override
	public List<ProductDto> get() throws BusinessException {
		List<ProductDto> productsDTO = new ArrayList<>();
		List<Product> products = productRepository.findAll();

		for (Product tmp : products) {
			productsDTO.add(parseProductToProductDto(tmp));
		}

		return productsDTO;
	}

	/**
	 * Se realiza conversion de {@link Product} a {@link ProductDto}
	 * 
	 * @param product
	 * @return ProductDto
	 */
	private ProductDto parseProductToProductDto(Product product) {
		if (product == null) {
			return new ProductDto();
		}

		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setDescription(product.getDescription());
		productDto.setModel(product.getModel());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());

		return productDto;
	}

}
