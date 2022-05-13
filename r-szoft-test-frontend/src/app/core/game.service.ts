import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from '../domain/game';
import { Guess } from '../domain/guess';
import { GuessResponse } from '../domain/guessResponse';
import { Player } from '../domain/player';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(
    private httpClient: HttpClient
  ) { }

  createGame(player: Player): Observable<Game> {
    return this.httpClient.post<Game>(`/api/game`, player);
  }

  guessNumber(gameId: number, guess: Guess): Observable<GuessResponse> {
    return this.httpClient.post<GuessResponse>(`/api/guess/${gameId}`, guess);
  }
}
