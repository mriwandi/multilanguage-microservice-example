package com.example.user.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("result", false);

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
			.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		response.put("errors", errors);
		return ResponseEntity.badRequest().body(response);
	}

	// Handles validation failures from constraints directly
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("result", false);
		response.put("error", ex.getMessage());
		return ResponseEntity.badRequest().body(response);
	}

	// Handles user service or listing service 4xx responses
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Map<String, Object>> handleClientError(HttpClientErrorException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("result", false);
		response.put("error", ex.getResponseBodyAsString());
		return ResponseEntity.status(ex.getStatusCode()).body(response);
	}

	// Handles user service or listing service 5xx responses
	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<Map<String, Object>> handleServerError(HttpServerErrorException ex) {
		log.error("Upstream service error: {}", ex.getMessage(), ex);
		Map<String, Object> response = new HashMap<>();
		response.put("result", false);
		response.put("error", "Upstream service error");
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
	}

	// Fallback for any unhandled exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGeneralError(Exception ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("result", false);
		response.put("error", "Internal server error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
