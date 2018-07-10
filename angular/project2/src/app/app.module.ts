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
<<<<<<< Updated upstream
import { AddPostComponent } from './add-post/add-post.component';
import { UserEditorComponent } from './user-editor/user-editor.component';
=======
import { MyPostsComponent } from './my-posts/my-posts.component';
>>>>>>> Stashed changes
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistationComponent,
    HomeComponent,
    NavbarComponent,
<<<<<<< Updated upstream
    AddPostComponent,
    UserEditorComponent
=======
    MyPostsComponent
>>>>>>> Stashed changes
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
