package com.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad del producto.
 * 
 * @author isivr
 *
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {

	/**
	 * Id del producto
	 */
	@Id
	private String id;

	/**
	 * Nombre del producto
	 */
	private String name;

	/**
	 * Descripcion del producto
	 */
	private String description;

	/**
	 * Precio del producto
	 */
	private Double price;

	/**
	 * Modelo del producto
	 */
	private String model;

	private boolean enabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
