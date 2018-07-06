import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserserviceService } from '../userservice.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-registation',
  templateUrl: './registation.component.html',
  styleUrls: ['./registation.component.css']
})
export class RegistationComponent implements OnInit {
  registrationForm : FormGroup;
  submitted = false;
  loading = false;
  returnUrl = '/login';

  constructor(private formBuilder: FormBuilder, private userService : UserserviceService, private router : Router) { }

  ngOnInit() 
  {
    this.registrationForm = this.formBuilder.group
    ({
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      emailAddress : ['', [Validators.required, Validators.email]],
      username : ['', [Validators.required, Validators.minLength(6)]],
      password : ['', [Validators.required, Validators.minLength(8)]]
    })
  }

  onSubmit()
  {
    this.submitted = true;

    if (this.registrationForm.invalid)
    {
      return;
    }

    this.loading = true;
    this.userService.register(this.registrationForm.value).
    pipe(first()).subscribe(
      data => 
      {
        alert('You registration was successful! :D');
        //Go back to the login
        this.router.navigate([this.returnUrl]);
      },
      error => 
      {
        this.loading = false;
      }
    )

    
  }
}
