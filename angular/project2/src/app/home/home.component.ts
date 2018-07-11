import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

import { Post } from '../post';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public posts: Post[];

  constructor(private postService: PostService, private router: Router) { }

  ngOnInit() {
    this.postService.getPosts().subscribe(resp => this.posts = resp);
  }

  getMyPosts()
  {
    this.router.navigate(['/myPosts']);
  }
}