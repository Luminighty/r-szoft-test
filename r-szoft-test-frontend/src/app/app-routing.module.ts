import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { GameComponent } from './game/game.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [{
  path: "home",
  component: HomeComponent,
}, {
  path: "game/:id",
  component: GameComponent,
}, {
  path: '**',
  redirectTo: '/home'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
