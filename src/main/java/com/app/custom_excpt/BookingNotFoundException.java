package com.app.custom_excpt;

@SuppressWarnings("serial")
public class BookingNotFoundException extends RuntimeException{
public BookingNotFoundException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
}
}
