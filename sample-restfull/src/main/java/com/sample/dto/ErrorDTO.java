package com.sample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Israel I. Rodriguez Espinoza.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = -3753846937272180822L;

	/**
	 * Descripcion sobre el error
	 */
	private String descripcion;

	/**
	 * Lista de errores
	 */
	private List<String> errores;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<String> getErrores() {
		return errores;
	}

	public void setErrores(List<String> errores) {
		this.errores = errores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorDTO [");
		if (descripcion != null) {
			builder.append("descripcion=");
			builder.append(descripcion);
			builder.append(", ");
		}
		if (errores != null) {
			builder.append("errores=");
			builder.append(errores);
		}
		builder.append("]");
		return builder.toString();
	}

}
