import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent} from 'src/app/home/home.component';
import { RegistationComponent } from 'src/app/registation/registation.component';
import { UserEditorComponent } from 'src/app/user-editor/user-editor.component';
import { AddPostComponent } from 'src/app/add-post/add-post.component';
import {MypostComponent} from 'src/app/mypost/mypost.component';
import { LoginComponent} from '../login/login.component';
import { MyPostsComponent } from '../my-posts/my-posts.component';
import { PostComponent } from '../post/post.component';

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
    path: 'post/:id',
    component: PostComponent
  },
  {
    path: 'mypost/:id',
    component: MypostComponent
  },
  {
    path: 'myPosts',
    component: MyPostsComponent
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
