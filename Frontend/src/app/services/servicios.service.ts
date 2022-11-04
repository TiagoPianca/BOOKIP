import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaderResponse,
  HttpHeaders,
  HttpParams,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Registros } from '../models/Registros';

//Para todos los mapping, utilizar service.
@Injectable({
  providedIn: 'root'
})
export class ServiciosService {
  private path = 'http://localhost:8080';
  constructor(private http: HttpClient) {
  }
  
  //Listar
  listarregistros(): Observable<Registros[]> {
    return this.http.get<Registros[]>(`${this.path}/listarregistros`)
  }

  //Buscar
  buscarregistropornombre(nombreabuscartemp:string){
    return this.http.get(`${this.path}/buscarpornombre`,{params :{nombreabuscartemp,},});
  }
  //Parametro como esta en el back.

  //Agregar
  nuevoregistro(registro : Registros){
    return this.http.post(`${this.path}/agregarreg`,
    {
      "id": registro.id,
      "numcliente": registro.numcliente,
      "nombrecliente": registro.nombrecliente,
      "maccpe": registro.maccpe,
      "direccionip": registro.direccionip,
      "activo": registro.activo
      //Parámetros que solicito desde el Back.
  },{responseType:'text'})
  }
  //Responsetype agarra la respuesta y retorna solo el texto de la respuesta.
}
