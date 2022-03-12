import { Regiao } from './../model/regiao';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(private http:HttpClient) { }

  listRegioes() : Observable<Regiao[]>{
    //const url = '/assets/regioes.json';
    const url = environment.urlApi+'regiao';
    return this.http.get<Regiao[]>(url);
  }
}
