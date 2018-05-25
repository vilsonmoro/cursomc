package com.vilson.cursomc.resources.excpetion;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vilson.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
  @ExceptionHandler(ObjectNotFoundException.class)	
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpRequest request){
	 StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

}
