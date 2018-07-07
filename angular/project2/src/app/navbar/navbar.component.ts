import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  title = 'Test Navbar';
  constructor() { }

  ngOnInit() {
  }
  getEditUser(): void {
    console.log('edittting');
  }
  logout(): void {
    console.log('logging out');
  }
}
