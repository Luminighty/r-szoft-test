package com.luminight.rszofttest.exceptions;


public class GameNotFoundException extends RuntimeException {
	
	public GameNotFoundException(long id) {
		super("Could not find game " + id);
	}
}
