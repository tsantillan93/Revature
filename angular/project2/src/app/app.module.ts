import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

// custom modules
import { AppRoutingModule } from './app-routing/app-routing.module';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { RegistationComponent } from './registation/registation.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddPostComponent } from './add-post/add-post.component';
import { UserEditorComponent } from './user-editor/user-editor.component';
import { MypostComponent } from './mypost/mypost.component';
import { MyPostsComponent } from './my-posts/my-posts.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistationComponent,
    HomeComponent,
    NavbarComponent,
    AddPostComponent,
    UserEditorComponent,
    MypostComponent,
    MyPostsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
