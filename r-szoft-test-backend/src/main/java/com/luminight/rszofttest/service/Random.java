package com.luminight.rszofttest.service;

public class Random {
	private Random() {}

	private static int min = 0;
	private static int max = 100;

	public static int getNumber() {
		return (int)(Math.random() * (max - min) + min);
	}
}
