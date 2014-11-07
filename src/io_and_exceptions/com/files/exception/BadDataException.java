package io_and_exceptions.com.files.exception;

public class BadDataException extends Exception {

	private String message;
	private String info = "Invalid Data: ";
	
	public BadDataException(String message){
		super(message);
		this.message = message;
	}
	
	public String getMessage(){
		return this.info+this.message;
	}
}
