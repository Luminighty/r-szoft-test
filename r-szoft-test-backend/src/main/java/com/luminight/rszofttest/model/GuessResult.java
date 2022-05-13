package com.luminight.rszofttest.model;

public class GuessResult {
	private int guesses;
	private long time;

	public GuessResult(int guesses, long time) {
		this.guesses = guesses;
		this.time = time;
	}

	public long getGuesses() {
		return guesses;
	}

	public long getTime() {
		return time;
	}
}
