import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { IncidenciaExame } from '../model/incidenciaexame';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IncidenciaExameService {

  constructor(private http:HttpClient) { }

  listIncidencias() : Observable<IncidenciaExame[]>{
    //const url = '/assets/incidencias.json';
    const url = environment.urlApi+'incidencia';
    return this.http.get<IncidenciaExame[]>(url);
  }
}
