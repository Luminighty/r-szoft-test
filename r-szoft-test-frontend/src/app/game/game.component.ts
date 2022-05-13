import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { GameService } from '../core/game.service';
import { EMPTY, Observable, switchMap } from 'rxjs';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {

  isOver: boolean = false;
  gameId!: number;
  form: FormGroup = this.fb.group({
    guess: ['', [Validators.required, Validators.min(0), Validators.max(100)]],
  });

  get guess(): AbstractControl {
    return this.form.get('guess') as AbstractControl;
  }

  constructor(
    private fb: FormBuilder,
    private gameService: GameService,
    private snackbar: MatSnackBar,
    private route: ActivatedRoute,
    private router: Router,
  ) { }


  ngOnInit(): void {

    this.route.paramMap.subscribe((params) => {
      this.gameId = parseInt(params.get("id")!);
    })
  }

  async submit(): Promise<void> {
    if (!this.form.valid)
      return;
    const guess = this.form.value;
    this.gameService.guessNumber(this.gameId, guess)
    .subscribe({
      next: (res) => {
        if (res.response === 'GREATER') {
          this.snackbar.open("A szám ennél nagyobb!", "Bezár", {duration: 3000})
        } else if (res.response === 'LESS') {
          this.snackbar.open("A szám ennél kisebb!", "Bezár", {duration: 3000})
        } else if (res.response === 'MATCH' && res.result) {
          this.isOver = true;
          const ref = this.snackbar.open(`Nyertél! Tippeid száma: ${res.result.guesses} Idő: ${res.result.time}mp`, "Bezár", {
            duration: 10000,
          })
          ref.afterDismissed().subscribe(() => {
            this.router.navigate(["home"]);
          });
        }
      },
      error: (err) => {
        this.router.navigate(["home"]);
      }
    });
  }
}
