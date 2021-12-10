import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {BakeryComponent} from "./bakery/bakery.component";


const routes: Routes = [
  { path: 'bakery', component: BakeryComponent },
  { path: '', redirectTo: 'bakery', pathMatch: 'full' }
];

@NgModule({
  declarations: [],
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
