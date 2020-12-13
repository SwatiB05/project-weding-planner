package com.app.custom_excpt;

public class CityNotFoundException extends RuntimeException{
	public CityNotFoundException(String msg) {
		super(msg);
	}
}
