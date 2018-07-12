import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Bid } from './bid';

@Injectable({
  providedIn: 'root'
})
export class BidService {
  private appUrl = 'http://localhost:8080/JenkinsProject/';
  constructor(private http: HttpClient) { }

  add(bid: Bid):  Observable<Bid> {
    console.log(bid);
    const body = bid;
    return this.http.post(this.appUrl + 'bid', body,
      { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }),
        withCredentials: true }).pipe(
        map(resp => bid = resp as Bid)
      );
  }

  get(id: number): Observable<Bid> {
    const url: string = this.appUrl + 'bid/' + id;
    return this.http.get(url, {withCredentials: true }).pipe(
      map(resp => resp as Bid)
    );
  }

  getBids(postId: number): Observable<Bid[]> {
    console.log('getBids()');
    return this.http.get(this.appUrl + 'bids/' + postId,
    { headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : 'localhost:4200' }),
      withCredentials: true }).pipe(
      map( resp => resp as Bid[])
    );
  }
}
