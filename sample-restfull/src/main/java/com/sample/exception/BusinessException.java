package com.sample.exception;

/**
 * Excepcion para errores controlados
 * 
 * @author Israel I. Rodriguez Espinoza.
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 3353793354378266506L;

	public BusinessException(String msg) {
		super(msg);
	}

}
