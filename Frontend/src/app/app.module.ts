import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { TablaComponent } from './tabla/tabla.component';
import { AgregarRegistroComponent } from './agregar-registro/agregar-registro.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    ButtonsComponent,
    TablaComponent,
    AgregarRegistroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
