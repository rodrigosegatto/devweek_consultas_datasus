import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { FaixaEtaria } from '../model/faixaetaria';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FaixaEtariaService {

  constructor(private http:HttpClient) { }

  listFaixaEtarias() : Observable<FaixaEtaria[]>{
    //const url = '/assets/incidencias.json';
    const url = environment.urlApi+'faixaetaria';
    return this.http.get<FaixaEtaria[]>(url);
  }
}
