import { Component } from '@angular/core';
import { Clientes } from './models/Clientes';
import { Registros } from './models/Registros';
import { Usuarios } from './models/Usuarios';
import { ServiciosService } from './services/servicios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';
  registroacrear: Registros = new Registros();
  clienteacrear: Clientes = new Clientes();
  usuarioacrear: Usuarios = new Usuarios();
  nombreclientetemp: string = "";
  currenttabla: any;
  constructor(private service: ServiciosService){

  }
  //FUNCIONA ESTE METODO
  mostrarregistro(){
    this.service.listarregistros().subscribe((dato) => {this.currenttabla = dato})
  }
  mostrarcliente(){
    this.service.listarclientes().subscribe((dato) => {this.currenttabla = dato})
  }
  mostrarusuario(){
    this.service.listarusuarios().subscribe((dato) => {this.currenttabla = dato})
  }
    //FUNCIONA ESTE METODO
  // buscarpornombrecli(){
  //   this.service.buscarregistropornombre(this.nombreclientetemp).subscribe(dato => {console.log(dato)})
  // }
  //FUNCIONA ESTE METODO
  nuevoregistro(){
    this.service.nuevoregistro(this.registroacrear).subscribe(dato => {console.log(dato)})
  }
  nuevocliente(){
    this.service.nuevocliente(this.clienteacrear).subscribe(dato => {console.log(dato)})
  }
  nuevousuario(){
    this.service.nuevousuario(this.usuarioacrear).subscribe(dato => {console.log(dato)})
  }
}
