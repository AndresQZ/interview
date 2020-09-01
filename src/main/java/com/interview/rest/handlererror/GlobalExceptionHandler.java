package com.interview.rest.handlererror;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


import com.interview.rest.exceptions.BadRequest;
import com.interview.rest.exceptions.UserNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ApiErrorHandler apiErrorHandler;

	
	@ExceptionHandler( {Exception.class , BadRequest.class, UserNotFound.class, NoHandlerFoundException.class})
	public ResponseEntity<Object> mainHandler(Exception ex, WebRequest request,  HttpServletRequest httpRequest) {
		if (ex instanceof BadRequest) {
			return BadRequestValidException((BadRequest) ex,request,httpRequest );
		}  else if (ex instanceof UserNotFound) {
		  return  userNotFoundException((UserNotFound) ex,request,httpRequest);
		} else if (ex instanceof NoHandlerFoundException) {
			return noHandlerFoundException((NoHandlerFoundException)ex , request, httpRequest);
		}
		else {
			 return new ResponseEntity<Object>(apiErrorHandler,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@ResponseStatus( HttpStatus.BAD_REQUEST)
	private ResponseEntity<Object> BadRequestValidException( BadRequest ex, WebRequest request, HttpServletRequest httpRequest) {
		  apiErrorHandler.setPath(httpRequest.getRequestURI());
		  apiErrorHandler.setMessage(ex.getMessage());
		  
		  return new ResponseEntity<Object>(apiErrorHandler, new HttpHeaders() ,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus( HttpStatus.BAD_REQUEST)
	private ResponseEntity<Object> userNotFoundException( UserNotFound ex, WebRequest request, HttpServletRequest httpRequest) {
		  apiErrorHandler.setPath(httpRequest.getRequestURI());
		  apiErrorHandler.setMessage(ex.getMessage());
		  
		  return new ResponseEntity<Object>(apiErrorHandler, new HttpHeaders() ,HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR)
	private ResponseEntity<Object>  noHandlerFoundException( NoHandlerFoundException ex, WebRequest request, HttpServletRequest httpRequest) {
		  apiErrorHandler.setPath(httpRequest.getRequestURI());
		  apiErrorHandler.setMessage( "Service not found");
		  
		  return new ResponseEntity<Object>(apiErrorHandler, new HttpHeaders() ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}