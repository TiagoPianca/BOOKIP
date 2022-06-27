import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Registros } from '../interfaces/registros';
import { TareasService } from '../servicios/tareas.service';

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})
export class ButtonsComponent implements OnInit {
  registros: Registros[];
  registro: Registros;
  constructor(private router:Router,private tareasservicio: TareasService) { }

  ngOnInit(): void {
  }
  public obtenerregistros(){
    this.tareasservicio.obtenerlistaregistros().subscribe((dato)=> {
      this.registros = dato;
    });
    
    }
  public agregarregistro(){
  /*  this.tareasservicio.AgregarRegistro(this.registro).subscribe((dato)=> {
      console.log(dato);
    })*/
    let link=['/agregar-registro'];
    this.router.navigate(link);
  }
  public modificarregistro(){

  } 
  public buscarpornombrecliente(){
    
  }
  public buscarpornumerocliente(){
    
  }
  public buscarpormaccpe(){

  }
  public buscarpordireccionip(){

  }
  }