import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Registros } from '../registros';
import { TareasService } from '../servicios/tareas.service';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {
  registros: Registros
  
  constructor(private tareaservice: TareasService) { 
  }

  ngOnInit(  ): void {}
  

}
