import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

<<<<<<< Updated upstream
import { LoginComponent} from 'src/app/login/login.component';
import { HomeComponent} from 'src/app/home/home.component';
import { RegistationComponent } from 'src/app/registation/registation.component';
import { UserEditorComponent } from 'src/app/user-editor/user-editor.component';
import { AddPostComponent } from 'src/app/add-post/add-post.component';
=======
import { LoginComponent} from '../login/login.component';
import { HomeComponent} from '../home/home.component';
import { RegistationComponent } from '../registation/registation.component';
import { MyPostsComponent } from '../my-posts/my-posts.component';

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    path: 'editUser',
    component: UserEditorComponent
  },
  {
    path: 'addPost',
    component: AddPostComponent
=======
    path: 'myPosts',
    component: MyPostsComponent
>>>>>>> Stashed changes
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
