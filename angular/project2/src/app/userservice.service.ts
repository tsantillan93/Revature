import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from './user';
import { LoginComponent } from './login/login.component';


@Injectable({
  providedIn: 'root'
})

export class UserserviceService {
  private appUrl = 'http://localhost:8080/JenkinsProject/';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
  private user: User;

  constructor(private http: HttpClient) { }
getUser(): User {
  return this.user;
}

  login(username: string, password: string): Observable<User> {
    if (username && password) {
      // we need to log in
      console.log(username + ' ' + password);
      const body = `username=${username}&password=${password}`;
      return this.http.post(this.appUrl + 'login', body, { headers: this.headers, withCredentials: true }).pipe(
        map(
          resp => {
            const user: User = resp as User;
            console.log(user);
            this.user = user;
            return user;
          }
        )
      );
    } else {
      // we are just checking to see if we're already logged in
      return this.http.get(this.appUrl + 'login', { withCredentials: true })
        .pipe(map(
          resp => {
            const user: User = resp as User;
            if (user) {
              this.user = user;
            }
            return user;
          }
        ));
    }
  }

  register(user: User) {
    console.log(user);
    const body = user;
    return this.http.post(this.appUrl + 'register', body,
      { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }), withCredentials: true }).pipe(
        map(resp => user = resp as User)
      );
  }
  
  update(user: User) {
    console.log(user);
    const body = user;
    return this.http.post(this.appUrl + 'updateUser', body,
      { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }), withCredentials: true }).pipe(
        map(resp => user = resp as User)
      );
  }


  logout(): Observable<Object> {
    return this.http.get(this.appUrl + 'logout', { withCredentials: true }).pipe(
      map(success => {
        this.user = null;
        return success;
      })
    );
  }
}

