import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserserviceService } from '../userservice.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { User } from '../user';

@Component({
  selector: 'app-user-editor',
  templateUrl: './user-editor.component.html',
  styleUrls: ['./user-editor.component.css']
})

export class UserEditorComponent implements OnInit {
  private registrationForm: FormGroup;
  private loggedUser: User;
  private submitted = false;
  private loading = false;

  constructor(private formBuilder: FormBuilder, private userService: UserserviceService, private router: Router) { }

  ngOnInit() {
      this.loggedUser = this.userService.getUser();
      if (this.loggedUser) {
        this.registrationForm = this.formBuilder.group({
          firstName : [this.loggedUser.firstName, Validators.required],
          lastName : [this.loggedUser.lastName, Validators.required],
          email : [this.loggedUser.email, [Validators.required, Validators.email]]
        });
      }

  }
  edit(): void {
    console.log('Inside edit component: ' + this.loggedUser);
    this.loading = true;
    this.loggedUser.firstName = this.registrationForm.controls.firstName.value;
    this.loggedUser.lastName = this.registrationForm.controls.lastName.value;
    this.loggedUser.email = this.registrationForm.controls.email.value;
    this.userService.update(this.loggedUser).
    pipe(first()).subscribe(
      data => {
        alert('Successfully updated info');

        this.router.navigate(['/home']);
      },
      error => {
        this.loading = false;
        alert('Something went wrong');
        // this.router.navigate(['/']);
      });
  }
}
