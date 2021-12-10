import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BakeryComponent } from './bakery/bakery.component';
import { AppRoutingModule } from './app-routing.module';
import { TableModule } from "primeng/table";
import {HttpClientModule} from "@angular/common/http";
import {DropdownModule} from "primeng/dropdown";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {InputNumberModule} from "primeng/inputnumber";
import {ButtonModule} from "primeng/button";

@NgModule({
  declarations: [
    AppComponent,
    BakeryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TableModule,
    DropdownModule, FormsModule, BrowserAnimationsModule,
    InputNumberModule,
    ButtonModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
