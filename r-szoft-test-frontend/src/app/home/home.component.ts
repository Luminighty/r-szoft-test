import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GameService } from '../core/game.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  form: FormGroup = this.fb.group({
    player: ['', Validators.required],
  });

  get player(): AbstractControl {
    return this.form.get('player') as AbstractControl;
  }


  constructor(
    private fb: FormBuilder,
    private gameService: GameService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  async submit(): Promise<void> {
    if (!this.form.valid)
      return;
    const player = this.form.value;
    this.gameService.createGame(player)
    .subscribe({
      next: (game) => {
        this.router.navigate(['game', game.id]);
      },
      error: (error) => {
        console.error(error);
      }
    })
  }

}
