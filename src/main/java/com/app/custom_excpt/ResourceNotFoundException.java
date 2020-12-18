package com.app.custom_excpt;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
