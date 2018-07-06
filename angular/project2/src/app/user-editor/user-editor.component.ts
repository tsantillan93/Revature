import { Component, OnInit } from '@angular/core';

import { UserserviceService } from 'src/app/userservice.service';

import { User } from 'src/app/user';

@Component({
  selector: 'app-user-editor',
  templateUrl: './user-editor.component.html',
  styleUrls: ['./user-editor.component.css']
})

export class UserEditorComponent implements OnInit {
  public loggedUser: User;
  private firstName: string;
  private lastName: string;
  private emailAddress: string;

  constructor(private userService: UserserviceService) { }

  ngOnInit() {
    // this.userService.edit(null, null, null).subscribe( user => {
    //   this.loggedUser = user;
    // });
  }
  edit(): void {
    console.log('Inside edit component: ' + this.loggedUser);
    // this.userService.edit(this.firstName, this.lastName, this.emailAddress).subscribe(
    //   user => {
    //     this.loggedUser = user;
    //   }
    // );
  }
}
