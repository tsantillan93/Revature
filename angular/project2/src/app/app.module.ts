import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistationComponent } from './registation/registation.component';

import { UserserviceService } from './userservice.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    UserserviceService
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
