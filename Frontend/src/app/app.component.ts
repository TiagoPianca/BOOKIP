import { Component } from '@angular/core';
import { TareasService } from './servicios/tareas.service';
import { HttpClient } from '@angular/common/http';
import { Registros } from './registros';
import { TablaComponent } from './tabla/tabla.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';
  respuesta = 'http://localhost:8080/';
  constructor(
    private http: HttpClient,
    private tareasService: TareasService
  ) { }
 
    ListarRegistros() {
      this.tareasService.obtenerlistaregistros()
      .subscribe(any => {
        console.log(any);
      });
    }
  }
