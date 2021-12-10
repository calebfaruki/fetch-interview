import { Component, OnInit } from '@angular/core';
import {BakeryService} from "../services/bakery.service";
import {Treat} from "../models/treat.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TableModule} from "primeng/table";
import {DropdownModule} from "primeng/dropdown";
import {InputNumberModule} from 'primeng/inputnumber';
import {ButtonModule} from 'primeng/button';
import {Sale} from "../models/sale.model";

@Component({
  selector: 'app-bakery',
  templateUrl: './bakery.component.html',
  styleUrls: ['./bakery.component.css']
})
export class BakeryComponent implements OnInit {

  headers = new HttpHeaders().set('Access-Control-Allow-Origin', '*')

  treats: Treat[] = [];
  sales: Sale[] = [];

  selectedSale: any;
  productsAndCounts: any = {};
  cost: number = 0;

  constructor(private bakeryService: BakeryService, private http: HttpClient) { }

  ngOnInit(): void {
    this.bakeryService.getSales().subscribe((sales: any) => {
      this.sales = [new Sale()];  // no sales
      this.sales = this.sales.concat(sales);
      this.sales.forEach(s => s.code = JSON.stringify(s));
    });

    this.bakeryService.getTreats().subscribe((treats: any) => {
      this.treats = treats as Treat[];
      this.treats.forEach(t => {
        t.code = t.name;  // for dropdown
        this.productsAndCounts[t.name] = 0;
      });

      for (let treat of this.treats) {
        // From object to string (to display json on html)
        treat.bulkPricingStr = JSON.stringify(treat.bulkPricing);

        // Get images
        if (treat.imageURL != undefined) {
          this.http.get(treat.imageURL, {'headers': this.headers})
            .subscribe(image => treat.image);
        }
      }
    });
  }

  clear() {
    this.treats.forEach(t => {
      this.productsAndCounts[t.name] = 0;
    });
  }

  computeTreats() {
    this.cost = -1;  // to show the users that something is changing
    let requestBody: any = {
      "productsAndCounts": this.productsAndCounts
    }
    if (this.selectedSale.id != 0) {
      requestBody['sales'] = this.selectedSale;
    }
    this.bakeryService.computeTreats(requestBody).subscribe((cost: any) => this.cost = cost)
  }
}
