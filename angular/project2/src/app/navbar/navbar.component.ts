import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
<<<<<<< Updated upstream
import { UserserviceService } from 'src/app/userservice.service';
import { User } from 'src/app/user';
=======
import { UserserviceService } from '../userservice.service';

>>>>>>> Stashed changes

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  title = 'Test Navbar';
  private user: User;
  constructor(
    private userService: UserserviceService, private router: Router
  ) { }

  ngOnInit() {
  }

  getEditUser(): void {
    this.router.navigate(['editUser']);
  }
  logout(): void {
    console.log('logging out');
    this.userService.logout().subscribe(
      object => {
        this.router.navigate(['/login']);
      }
    );
  }

  addPost() {
    this.router.navigate(['addPost']);
  }
}
