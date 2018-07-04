import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from './user';


@Injectable({
  providedIn: 'root'
})

export class UserserviceService {
  private appUrl = 'http://localhost:8080/JenkinsProject/login';
  private headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
  private user: User;

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    if (username && password) {
      // we need to log in
      console.log(username);
      const body = `user=${username}&pass=${password}`;
      return this.http.post(this.appUrl, body, { headers: this.headers, withCredentials: true }).pipe(
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
      return this.http.get(this.appUrl, { withCredentials: true })
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

}
