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
    this.service.modificarregistro(this.registroacrear).subscribe(dato => {console.log(dato)})
  }
}
