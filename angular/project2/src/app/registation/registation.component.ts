import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserserviceService } from '../userservice.service';
import { first } from 'rxjs/operators';
import { User } from '../user';

@Component({
  selector: 'app-registation',
  templateUrl: './registation.component.html',
  styleUrls: ['./registation.component.css']
})
export class RegistationComponent implements OnInit {
  registrationForm : FormGroup;
  user : User;
  submitted = false;
  loading = false;

  constructor(private formBuilder: FormBuilder, private userService : UserserviceService, private router : Router) { }

  ngOnInit() 
  {
    this.registrationForm = this.formBuilder.group
    ({
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      email : ['', [Validators.required, Validators.email]],
      username : ['', [Validators.required, Validators.minLength(6)]],
      password : ['', [Validators.required, Validators.minLength(8)]]
    })
  }

  onSubmit()
  {
    console.log("Submit clicked.");
    this.submitted = true;

    if (this.registrationForm.invalid)
    {
      console.log("Form was invalid");
      return;
    }

    this.loading = true;
    this.user = new User();
    this.user.id = 0;
    this.user.firstName = this.registrationForm.controls.firstName.value;
    this.user.lastName = this.registrationForm.controls.lastName.value;
    this.user.email = this.registrationForm.controls.email.value;
    this.user.username = this.registrationForm.controls.username.value;
    this.user.password = this.registrationForm.controls.password.value;
    
    console.log(this.user);
    this.userService.register(this.user).
    pipe(first()).subscribe(
      data => 
      {
        alert('You registration was successful! :D');
        //Go back to the login
        this.router.navigate(['/login']);
      },
      error => 
      {
        this.loading = false;
        console.log("Going back to /register");
        this.router.navigate(['/register']);
      }
    )

    
  }
}
