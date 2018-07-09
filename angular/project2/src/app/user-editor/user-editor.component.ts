import { Component, OnInit } from '@angular/core';

import { UserserviceService } from 'src/app/userservice.service';

import { User } from 'src/app/user';

@Component({
  selector: 'app-user-editor',
  templateUrl: './user-editor.component.html',
  styleUrls: ['./user-editor.component.css']
})

export class UserEditorComponent implements OnInit {
  private loggedUser: User;
  private firstName: string;
  private lastName: string;
  private emailAddress: string;

  constructor(private userService: UserserviceService) { }

  ngOnInit() {
      this.loggedUser = this.userService.getUser();
      if (this.loggedUser) {
              console.log(this.loggedUser);
      this.firstName = this.loggedUser.firstName;
      this.lastName = this.loggedUser.lastName;
      this.emailAddress = this.loggedUser.email;
      }

  }
  edit(): void {
    console.log('Inside edit component: ' + this.loggedUser);
    this.loggedUser.firstName = this.firstName;
    this.loggedUser.lastName = this.lastName;
    this.loggedUser.email = this.emailAddress;
    this.userService.update(this.loggedUser);
  }
}
