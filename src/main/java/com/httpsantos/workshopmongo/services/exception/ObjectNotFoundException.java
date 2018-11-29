package com.httpsantos.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	//RUNTIMEEXCEPTION COPILADOR N EXIGE QUE SEJA TRATADA
	private static final long serialVersionUID = 1L; 
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
