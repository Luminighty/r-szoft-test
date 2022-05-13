package com.luminight.rszofttest.exceptions;


public class GameFinishedException extends RuntimeException {
	
	public GameFinishedException(long id) {
		super("Game " + id + " already finished");
	}
}
