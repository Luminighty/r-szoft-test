package com.luminight.rszofttest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GameAdvice {
	
	@ResponseBody
	@ExceptionHandler(GameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String gameNotFoundHandler(GameNotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(GameFinishedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String gameFinishedHandler(GameFinishedException ex) {
		return ex.getMessage();
	}
}
