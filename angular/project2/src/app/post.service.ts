import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Post } from './post';
import { User } from './user';
import { UserserviceService } from './userservice.service';

// import { loggedUser } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private appUrl = 'http://localhost:8080/JenkinsProject/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
  public user: User;
  private params: HttpParams;

  constructor(private http: HttpClient, private userService: UserserviceService) { }

  add(post: Post) {
    console.log(post);
    const body = post;
    return this.http.post(this.appUrl + 'post', body,
      { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }),
        withCredentials: true }).pipe(
        map(resp => post = resp as Post)
      );
  }

  get(id: number): Observable<Post> {
    const url: string = this.appUrl + 'post/' + id;

    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Post)
    );
  }

  update(post: Post) {
    console.log(post);
    const body = post;
    return this.http.put(this.appUrl + 'updatePost', body,
    { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }), withCredentials: true }).pipe(
      map(resp => post = resp as Post)
      );
  }

  getPosts(): Observable<Post[]> {
    console.log('getPosts() in postService');
    return this.http.get(this.appUrl + 'getPosts', { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }),
    withCredentials: true }).pipe(
      map( resp => resp as Post[])
    );
  }

  getMyPosts(): Observable<Post[]>{
    console.log("getPosts() in postService");
    this.user = this.userService.getUser();
    console.log(this.user);
    return this.http.get(this.appUrl + 'getMyPosts/' + this.user.id.toString(), { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }), withCredentials: true }).pipe(
      map( resp => resp as Post[])
    );
  }
}
