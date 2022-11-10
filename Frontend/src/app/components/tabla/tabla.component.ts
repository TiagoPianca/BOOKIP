import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabla',
  templateUrl: './tabla.component.html',
  styleUrls: ['./tabla.component.css']
})
export class TablaComponent implements OnInit {

  constructor() { }

  @Input() tabla: any

  ngOnInit(): void {
  }

  mostrar(){
    console.log(this.tabla)
  }

  getKeys(data: any){
    return Object.keys(data);
  }
}
