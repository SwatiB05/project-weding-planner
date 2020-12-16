package com.app.custom_excpt;

@SuppressWarnings("serial")
public class CityNotFoundException extends RuntimeException{
	public CityNotFoundException(String msg) {
		super(msg);
	}
}
