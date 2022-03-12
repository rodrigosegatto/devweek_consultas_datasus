import { IncidenciaExame } from './../model/incidenciaexame';
import { FaixaEtaria } from './../model/faixaetaria';
import { RegiaoService } from './../service/regiao.service';
import { Regiao } from './../model/regiao';
import { Component, OnInit } from '@angular/core';
import { FaixaEtariaService } from '../service/faixaetaria.service';
import { IncidenciaExameService } from '../service/incidenciaexame.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css']
})
export class OcorrenciasComponent implements OnInit {

  incidencia_exame: IncidenciaExame[] = [];
  regioes: Regiao[] = [];
  faixaEtarias: FaixaEtaria[] = [];

  constructor(
    private regiaoService:RegiaoService,
    private faixaEtariaService:FaixaEtariaService,
    private incidenciaExameService:IncidenciaExameService
  ) { }

  ngOnInit(): void {
    this.regiaoService.listRegioes().subscribe(regioes => {this.regioes = regioes});
    this.faixaEtariaService.listFaixaEtarias().subscribe(faixaEtarias => {this.faixaEtarias = faixaEtarias});
    this.incidenciaExameService.listIncidencias().subscribe(incidencia_exame => {this.incidencia_exame = incidencia_exame});
  }


}
