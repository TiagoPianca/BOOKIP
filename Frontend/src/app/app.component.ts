import { Component } from '@angular/core';
import { TareasService } from './servicios/tareas.service';
import { HttpClient } from '@angular/common/http';

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
  ngOnInit() {
    this.http.get("http://localhost:8080/listarregistros",{responseType:'text' }).subscribe((resp: any) =>{
      this.title = resp;
    }),
    (error:any) =>{
      console.log(error)
    }
}
}
