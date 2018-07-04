import { Component, OnInit } from '@angular/core';

import { UserserviceService } from 'src/app/userservice.service';

import { User } from 'src/app/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  public loggedUser: User;
  private username: string;
  private password: string;

  constructor(
    private userService: UserserviceService
  ) { }

  ngOnInit() {
    this.userService.login(null, null).subscribe( user => {
      this.loggedUser = user;
      //  purchase stuff
    });
  }
  login(): void {
    console.log('Inside login component: '+ this.username);
    this.userService.login(this.username, this.password).subscribe(
      user => {
        this.loggedUser = user;
        // purchase stuff
      }
    );
  }
}

