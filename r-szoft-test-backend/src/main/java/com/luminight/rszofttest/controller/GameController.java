package com.luminight.rszofttest.controller;

import com.luminight.rszofttest.exceptions.GameNotFoundException;
import com.luminight.rszofttest.model.Game;
import com.luminight.rszofttest.repository.GameRepository;
import com.luminight.rszofttest.service.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

	private final GameRepository repository;

	GameController(GameRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/game")
	public GameResponse newGame(@RequestBody PlayerRequest player) {
		Game game = new Game();
		game.setPlayer(player.getPlayer());
		game.setNumber(Random.getNumber());
		return new GameResponse(repository.save(game));
	}

	@GetMapping("/game/{id}")
	public Game one(@PathVariable long id) {
		return repository.findById(id)
			.orElseThrow(() -> new GameNotFoundException(id));
	}

	public static class PlayerRequest {
		private String player;
	
		public String getPlayer() {
			return player;
		}
	
		public void setPlayer(String player) {
			this.player = player;
		}
	}

	public static class GameResponse {
		private final long id;
	
		public GameResponse(Game game) {
			this.id = game.getId();
		}
	
		public long getId() {
			return id;
		}
	}
	
}
