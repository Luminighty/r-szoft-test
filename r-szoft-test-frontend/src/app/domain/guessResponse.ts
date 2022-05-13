export interface GuessResponse {
  response: "LESS" | "GREATER" | "MATCH",
  result?: GuessResult
}

export interface GuessResult {
  guesses: number,
  time: number,
}
