import { Component, Input, OnInit } from '@angular/core';
import { isFormControl } from '@angular/forms';
import { Clientes } from 'app/models/Clientes';
import { Registros } from 'app/models/Registros';
import { Usuarios } from 'app/models/Usuarios';
import { ServiciosService } from 'app/services/servicios.service';
import Swal, { SweetAlertIcon } from 'sweetalert2';

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

  mostrar() {
    console.log(this.tabla)
  }

  getKeys(data: any) {
    return Object.keys(data);
  }
  nuevoregistro() {
    this.service.nuevoregistro(this.registroacrear).subscribe(dato => {
      let icono: SweetAlertIcon;

      if(dato == 'Registro guardado exitosamente'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })
    })
  }
  nuevocliente() {
    this.service.nuevocliente(this.clienteacrear).subscribe(dato => {
      let icono: SweetAlertIcon;

      if(dato == 'Cliente guardado exitosamente'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })
     })
  }
  nuevousuario() {
    this.service.nuevousuario(this.usuarioacrear).subscribe(dato => { 
      let icono: SweetAlertIcon;

      if(dato == 'Usuario guardado exitosamente'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })
    })
  }
  modificarregistro() {
    let id: number
    this.service.modificarregistro(this.registroacrear.id, this.registroacrear).subscribe(dato => {
      let icono: SweetAlertIcon;

      if(dato == 'Registro modificado'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })
     })
  }
  modificarcliente() {
    let nombrecliente: string
    this.service.modificarcliente(this.clienteacrear.nombrecliente, this.clienteacrear).subscribe(dato => {
      let icono: SweetAlertIcon;

      if(dato== 'Cliente modificado'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })
    })
  }
  modificarusuario() {
    let nombreusuario: string
    this.service.modificarusuario(this.usuarioacrear.nombreusuario, this.usuarioacrear).subscribe(dato => { 
      let icono: SweetAlertIcon;

      if(dato== 'Usuario modificado'){
        icono = "success";
      }else{
        icono = "error";
      }

      Swal.fire({
        position: 'top',
        icon: icono,
        title: dato,
        timer: undefined
      })

    })
  }
  deshabilitarregistro(){
    let id: number
    this.service.deshabilitarregistro(this.registroacrear.id, this.registroacrear).subscribe(dato => {console.log(dato)})
  }
}
