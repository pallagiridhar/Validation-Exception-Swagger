package com.techpalle.swagger.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationHandler
{
	@ExceptionHandler(value= MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
    	Map<String,String> map=new HashMap<>();
    	ex.getAllErrors().stream().forEach(r ->
    	{
    		String fieldName=((FieldError)r).getField();
    		String errorName=r.getDefaultMessage();
    		map.put(fieldName, errorName);
    	});
    	return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}
}
