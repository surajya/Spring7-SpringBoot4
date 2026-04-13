package com.sp.jobportal.error;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.sp.jobportal.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> handleException(Exception exception, WebRequest webRequest) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR, "Exception : " + exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>>
			handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		Map<String, List<String>> errors = exception.getBindingResult().getFieldErrors().stream()
				.collect(Collectors.groupingBy(error -> error.getField(),
						Collectors.mapping(error -> error.getDefaultMessage(),
								Collectors.toList())));
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponseDto> handleNullPointerException(Exception exception, WebRequest webRequest) {
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR, "NullPointerException : " + exception.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
