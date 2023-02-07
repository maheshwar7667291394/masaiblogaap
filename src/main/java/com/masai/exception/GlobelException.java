package com.masai.exception;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {
	
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<MyError> GEtCommetException(CommentException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BlogException.class)
	public ResponseEntity<MyError> getBlogException(BlogException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> getCustomerException(UserException ce,WebRequest req){
		
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LogeinException.class)
	public ResponseEntity<MyError> getLoginException(LogeinException ce,WebRequest req){
		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}
	



	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> getAllException(Exception ce,WebRequest req){

		MyError err=new MyError();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}

}
