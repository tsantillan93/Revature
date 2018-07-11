import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent} from 'src/app/login/login.component';
import { HomeComponent} from 'src/app/home/home.component';
import { RegistationComponent } from 'src/app/registation/registation.component';
import { UserEditorComponent } from 'src/app/user-editor/user-editor.component';
import { AddPostComponent } from 'src/app/add-post/add-post.component';
import {MypostComponent} from 'src/app/mypost/mypost.component';
const routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'register',
    component: RegistationComponent
  },
  {
    path: 'editUser',
    component: UserEditorComponent
  },
  {
    path: 'addPost',
    component: AddPostComponent
  },
  {
    path: 'mypost',
    component: MypostComponent
  },
  {
    path: 'mypost/:id',
    component: MypostComponent
  }
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
