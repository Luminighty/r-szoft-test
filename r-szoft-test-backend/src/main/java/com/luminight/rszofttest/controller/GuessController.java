package com.luminight.rszofttest.controller;

import java.util.Date;

import com.luminight.rszofttest.exceptions.GameFinishedException;
import com.luminight.rszofttest.exceptions.GameNotFoundException;
import com.luminight.rszofttest.model.Game;
import com.luminight.rszofttest.model.GuessResponse;
import com.luminight.rszofttest.repository.GameRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuessController {
	
	private final GameRepository repository;

	GuessController(GameRepository repository) {
	  this.repository = repository;
	}
	
	@PostMapping("/guess/{id}")
	public GuessResponse guessNumber(@PathVariable Long id, @RequestBody GuessRequest guess) {
		Game game =  repository.findById(id)
			.orElseThrow(() -> new GameNotFoundException(id));
		if (game.getEndTime() != null)
			throw new GameFinishedException(id);
		
		game.incrementGuesses();
		
		int number = game.getNumber();
		int guessNumber = guess.getGuess();
		GuessResponse response;
		if (number < guessNumber) {
			response = GuessResponse.Less();
		} else if (number > guessNumber) {
			response = GuessResponse.Greater();
		} else {
			game.setEndTime(new Date());
			response = GuessResponse.Match(game.getGuesses(), game.getSeconds());
		}
		repository.save(game);
		
		return response;
	}

	public static class GuessRequest {
		private int guess;
	
		public int getGuess() {
			return guess;
		}
	
		public void setGuess(int guess) {
			this.guess = guess;
		}
	}
}
