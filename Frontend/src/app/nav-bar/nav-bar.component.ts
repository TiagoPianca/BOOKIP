import { Component, OnInit } from '@angular/core';
import { Registros } from '../interfaces/registros';
import { TareasService } from '../servicios/tareas.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  registros: Registros[];


  constructor(private tareasservicio: TareasService) { }

  ngOnInit(): void {
    this.obtenerregistros();
  }

  public obtenerregistros(){
    this.tareasservicio.obtenerlistaregistros().subscribe((dato)=> {
      this.registros = dato;
    });
  }

}
