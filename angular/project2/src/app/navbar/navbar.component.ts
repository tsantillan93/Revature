import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from 'src/app/userservice.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  title = 'Test Navbar';
  constructor(
    private userService: UserserviceService, private router: Router
  ) { }

  ngOnInit() {
  }
  getEditUser(): void {
    console.log('edittting');
  }
  logout(): void {
    console.log('logging out');
    this.userService.logout().subscribe(
      object => {
        this.router.navigate(['/login']);
      }
    );
  }
}
