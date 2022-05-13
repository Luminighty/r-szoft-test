package com.luminight.rszofttest.model;

public enum GuessResponseType {
	LESS("less"),
	GREATER("greater"),
	MATCH("match");

	private final String value;

	private GuessResponseType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
}
