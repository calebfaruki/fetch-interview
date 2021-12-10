import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class BakeryService {

  constructor(private http: HttpClient) { }

  getSales() {
    return this.http.get(environment.bakeryApi + "/sales")
  }

  getTreats() {
    return this.http.get(environment.bakeryApi + "/treats")
  }

  computeTreats(data: any) {
    return this.http.post(environment.bakeryApi + "/treats/compute", data)
  }
}
