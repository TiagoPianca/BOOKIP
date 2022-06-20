import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Registros } from './../interfaces/registros';
import { Usuarios } from './../interfaces/usuarios';

@Injectable({
  providedIn: 'root'
})
export class TareasService {
  private path = "http://localhost:8080/";
  respuesta = "";

  constructor(
    private http: HttpClient
  ) { }
prueba(

){this.http
  .get('http://localhost:8080/prueba', { responseType: 'text' })
  .subscribe((resp: any) => {
    this.respuesta = resp;
  }),
  (error: any) => {
    console.log(error);
  };}

}
