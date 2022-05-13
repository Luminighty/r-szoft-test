package com.luminight.rszofttest.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String player;

	@Column(nullable = false)
	private int number;

	@Column(nullable = false)
	private Date startTime = new Date();

	private Date endTime = null;

	@Column(nullable = false)
	private int guesses = 0;


	public int getGuesses() {
		return guesses;
	}

	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}

	public void incrementGuesses() {
		this.guesses++;
	}

	public long getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getSeconds() {
		if (this.startTime == null || this.endTime == null)
			return 0;
		long diff = endTime.getTime() - startTime.getTime();
		return TimeUnit.MILLISECONDS.toSeconds(diff);
	}
}
