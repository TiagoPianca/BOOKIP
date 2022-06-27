import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { AgregarRegistroComponent } from './agregar-registro/agregar-registro.component';
import { ButtonsComponent } from './buttons/buttons.component';


const routes: Routes = [
  {path:'agregar-registro', component:AgregarRegistroComponent},
  {path: '', component:ButtonsComponent}
    
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
