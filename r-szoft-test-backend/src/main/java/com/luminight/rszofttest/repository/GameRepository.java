package com.luminight.rszofttest.repository;

import com.luminight.rszofttest.model.Game;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
	
}