import { Component, Input, OnInit } from '@angular/core';
import { Clientes } from 'app/models/Clientes';
import { Registros } from 'app/models/Registros';
import { Usuarios } from 'app/models/Usuarios';
import { ServiciosService } from 'app/services/servicios.service';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {
  registroacrear: Registros = new Registros();
  clienteacrear: Clientes = new Clientes();
  usuarioacrear: Usuarios = new Usuarios();

  constructor(private service: ServiciosService) { }

  @Input() tabla: any

  ngOnInit(): void {
  }

  mostrar(){
    console.log(this.tabla)
  }

  getKeys(data: any){
    return Object.keys(data);
  }
  nuevoregistro(){
    this.service.nuevoregistro(this.registroacrear).subscribe(dato => {console.log(dato)})
  }
  nuevocliente(){
    this.service.nuevocliente(this.clienteacrear).subscribe(dato => {console.log(dato)})
  }
  nuevousuario(){
    this.service.nuevousuario(this.usuarioacrear).subscribe(dato => {console.log(dato)})
  }
  modificarregistro(){
    let id:number
    this.service.modificarregistro(this.registroacrear.id,this.registroacrear).subscribe(dato => {console.log(dato)})
  }
  modificarcliente(){
    let nombrecliente: string
    this.service.modificarcliente(this.clienteacrear.nombrecliente,this.clienteacrear).subscribe(dato => {console.log(dato)})
  }
  modificarusuario(){
    let nombreusuario: string
    this.service.modificarusuario(this.usuarioacrear.nombreusuario,this.usuarioacrear).subscribe(dato => {console.log(dato)})
  }
}