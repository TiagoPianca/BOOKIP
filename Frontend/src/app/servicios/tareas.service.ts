import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Usuarios } from './../interfaces/usuarios';
import { Observable } from 'rxjs';
import { Registros } from '../registros';

@Injectable({
  providedIn: 'root'
})
export class TareasService {
  private path = "http://localhost:8080/";
  respuesta = "";

  constructor(
    private http: HttpClient
  ) { }

  obtenerlistaregistros():Observable<Registros[]>{
    return this.http.get<Registros[]>(`http://localhost:8080/listarregistros`);
  }

  AgregarRegistro(registro:Registros):Observable<Object>{
    return this.http.post(`${this.path}agregarregistro`, registro);
  }
}
