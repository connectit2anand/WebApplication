package com.anand.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ex,WebRequest webRequest){
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setMessage(ex.getMessage());
		myErrorDetails.setTime(LocalDateTime.now());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException ex,WebRequest webRequest){
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setMessage(ex.getMessage());
		myErrorDetails.setTime(LocalDateTime.now());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> routeExceptionHandler(RouteException ex,WebRequest webRequest){
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		myErrorDetails.setMessage(ex.getMessage());
		myErrorDetails.setTime(LocalDateTime.now());
		myErrorDetails.setDetails(webRequest.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMethodArgumentNotValidException(MethodArgumentNotValidException me){
		MyErrorDetails err = new MyErrorDetails();
		err.setTime(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
