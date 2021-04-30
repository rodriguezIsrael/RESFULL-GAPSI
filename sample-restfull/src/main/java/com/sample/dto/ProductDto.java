package com.sample.dto;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Israel I. Rodriguez Espinoza.
 */
@JsonInclude(Include.NON_NULL)
@Valid
public class ProductDto {

	@NotNull(message = "El Id es obligatorio")
	@NotEmpty(message = "El Id es obligatorio")
	@Size(max = 10,message = "El id solo soporta 10 caracteres o menos")
	private String id;

	@NotNull(message = "El nombre es obligatorio")
	@NotEmpty(message = "El nombre es obligatorio")
	@Size(max = 20,message = "El nombre solo soporta 20 caracteres o menos")
	private String name;

	@NotNull(message = "La descripcion es obligatoria")
	@NotEmpty(message = "La descripcion es obligatoria")
	@Size(max = 200,message = "La descripcion solo soporta 200 caracteres o menos")
	private String description;

	@NotNull(message = "El precio es obligatorio")
	@DecimalMin(value = "0.0000000001", message = "El precio debe ser mayor a cero.")
	private Double price;

	@NotNull(message = "El modelo es obligatorio")
	@NotEmpty(message = "El modelo es obligatorio")
	@Size(max = 10,message = "El modelo solo soporta 10 caracteres o menos")
	private String model;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("productDto [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
			builder.append(", ");
		}
		if (price != null) {
			builder.append("price=");
			builder.append(price);
			builder.append(", ");
		}
		if (model != null) {
			builder.append("model=");
			builder.append(model);
		}
		builder.append("]");
		return builder.toString();
	}

}
