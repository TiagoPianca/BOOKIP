import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaderResponse,
  HttpHeaders,
  HttpParams,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Registros } from '../models/Registros';
import { Clientes } from 'app/models/Clientes';
import { Usuarios } from 'app/models/Usuarios';

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
  listarclientes(): Observable<Clientes[]> {
    return this.http.get<Clientes[]>(`${this.path}/listarclientes`)
  }
  listarusuarios(): Observable<Usuarios[]> {
    return this.http.get<Usuarios[]>(`${this.path}/listarusuarios`)
  }

  //Buscar
  buscarregistropornombre(nombreabuscartemp: string) {
    return this.http.get(`${this.path}/buscarpornombre`, { params: { nombreabuscartemp, }, });
  }
  //Parametro como esta en el back.

  //Agregar
  nuevoregistro(registro: Registros) {
    return this.http.post(`${this.path}/agregarreg`,
      {
        "id": registro.id,
        "numcliente": registro.numcliente,
        "nombrecliente": registro.nombrecliente,
        "maccpe": registro.maccpe,
        "direccionip": registro.direccionip,
        "activo": registro.activo
        //Parámetros que solicito desde el Back.
      }, { responseType: 'text' })
  }
  //Responsetype agarra la respuesta y retorna solo el texto de la respuesta.
  nuevocliente(cliente: Clientes) {
    return this.http.post(`${this.path}/agregarcli`,
      {
        "nombrecliente": cliente.nombrecliente,
        "nombreusuario": cliente.nombreusuario,
        "ciudad": cliente.ciudad,
        "activo": cliente.activo
        //Parámetros que solicito desde el Back.
      }, { responseType: 'text' })
  }
  nuevousuario(usuario: Usuarios) {
    return this.http.post(`${this.path}/agregaruser`,
      {
        "nombreusuario": usuario.nombreusuario,
        "password": usuario.password,
        "direccioncorreo": usuario.direccioncorreo,
        "nivelacceso": usuario.nivelacceso,
        "activo": usuario.activo
        //Parámetros que solicito desde el Back.
      }, { responseType: 'text' })
  }
  modificarregistro(id: number,registro: Registros) {
    return this.http.put(`${this.path}/modificarregistro/`,
      {
        "id": registro.id,
        "numcliente": registro.numcliente,
        "nombrecliente": registro.nombrecliente,
        "maccpe": registro.maccpe,
        "direccionip": registro.direccionip,
        "activo": registro.activo
      }, { responseType: 'text' })
  }
  modificarcliente(nombrecliente: string, cliente: Clientes){
    return this.http.put(`${this.path}/modificarcliente/`,
    {
      "nombreusuario": cliente.nombrecliente,
      "nombrecliente": cliente.nombrecliente,
      "ciudad": cliente.ciudad,
      "activo": cliente.activo
    }, {responseType: 'text' })
  }
  modificarusuario(nombreusuario: string, usuario: Usuarios){
    return this.http.put(`${this.path}/modificarusuario/`,
    {
      "nombreusuario": usuario.nombreusuario,
      "direccioncorreo": usuario.direccioncorreo,
      "password": usuario.password,
      "nivelacceso": usuario.nivelacceso,
      "activo": usuario.activo
    }, {responseType: 'text'})
  }
}
