import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrosComponentComponent } from './components/registros-component/registros-component.component';
import { ClientesComponentComponent } from './components/clientes-component/clientes-component.component';
import { UsuariosComponentComponent } from './components/usuarios-component/usuarios-component.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    RegistrosComponentComponent,
    ClientesComponentComponent,
    UsuariosComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
