import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Post } from './post';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private appUrl = 'http://localhost:8080/JenkinsProject/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

  constructor(private http: HttpClient) { }

  add() {

  }

  get() {

  }

  update() {

  }

  getPosts() {

  }

  getMyPosts() {

  }
}
