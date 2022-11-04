import { Component } from '@angular/core';
import { Registros } from './models/Registros';
import { ServiciosService } from './services/servicios.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';
  registroacrear: Registros = new Registros();
  nombreclientetemp: string = "";
  constructor(private service: ServiciosService){

  }
  //FUNCIONA ESTE METODO
  mostrarregistro(){
    this.service.listarregistros().subscribe(dato => {console.log(dato)})
  }
    //FUNCIONA ESTE METODO
  buscarpornombrecli(){
    this.service.buscarregistropornombre(this.nombreclientetemp).subscribe(dato => {console.log(dato)})
  }
  //FUNCIONA ESTE METODO
  nuevoregistro(){
    this.service.nuevoregistro(this.registroacrear).subscribe(dato => {console.log(dato)})
  }
}
