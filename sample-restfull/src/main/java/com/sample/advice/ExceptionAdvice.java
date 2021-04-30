package com.sample.advice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sample.dto.ErrorDTO;
import com.sample.exception.BusinessException;

/**
 *
 * @author Israel I. Rodriguez E.
 *
 */
@RestControllerAdvice
public class ExceptionAdvice {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<Object> handleThrowable(Throwable e) {
		ErrorDTO errorDTO = new ErrorDTO();
		List<String> errors = new ArrayList<>();
		if (e instanceof MissingServletRequestParameterException) {

			String param = ((MissingServletRequestParameterException) e).getParameterName();

			errorDTO.setDescripcion("Información incorrecta");
			errors.add("El parametro es requerido " + param);
			errorDTO.setErrores(errors);
			return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		LOG.error("Surgio error desconocido: [Throwable]", e);
		errors.add(e.getMessage());
		errorDTO.setErrores(errors);
		errorDTO.setDescripcion("Solicitud no procesada.");
		LOG.error("Error  enviado: {}", errorDTO);

		return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
		List<String> errors = new ArrayList<>();
		for (ObjectError error : allErrors) {
			errors.add(error.getDefaultMessage());
		}

		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setDescripcion("Informacion invalida.");
		errorDTO.setErrores(errors);
		LOG.error("Error de tipo: [MethodArgumentNotValidException]", e);
		LOG.error("Error  enviado: {}", errorDTO);

		return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> handleBussinesException(BusinessException e) {

		List<String> errors = new ArrayList<>();
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setDescripcion("Informacion invalida");

		errors.add(e.getMessage());
		errorDTO.setErrores(errors);
		LOG.error("Error de tipo: [BusinessException]", e.getMessage());
		LOG.error("Error  enviado: {}", errorDTO);

		return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);

	}

	@ExceptionHandler(value = TimeoutException.class)
	public ResponseEntity<Object> handleTimeoutException(TimeoutException e) {
		ErrorDTO errorDTO = new ErrorDTO();

		errorDTO.setDescripcion(e.getMessage());
		LOG.error("Error de tipo: [TimeoutException]", e);
		LOG.error("Error  enviado: {}", errorDTO);
		return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

	}

}
