package com.luminight.rszofttest.model;

public class GuessResponse {
	private GuessResponseType response;
	private GuessResult result; 

	public GuessResponse(GuessResponseType type, GuessResult result) {
		this.response = type;
		this.result = result;
	}

	public static GuessResponse Less() {
		return new GuessResponse(GuessResponseType.LESS, null);
	}

	public static GuessResponse Greater() {
		return new GuessResponse(GuessResponseType.GREATER, null);
	}

	public static GuessResponse Match(int guesses, long time) {
		GuessResult result = new GuessResult(guesses, time);
		return new GuessResponse(GuessResponseType.MATCH, result);
	}


	public GuessResponseType getResponse() {
		return response;
	}

	public GuessResult getResult() {
		return result;
	}
}
