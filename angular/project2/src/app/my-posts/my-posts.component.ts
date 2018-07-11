import { Component, OnInit } from '@angular/core';

import { PostService } from '../post.service';

import { Post } from '../post';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.css']
})
export class MyPostsComponent implements OnInit {
  public myPosts: Post[];

  constructor(private postService: PostService, private router: Router) { }

  ngOnInit() {
    this.postService.getMyPosts().subscribe(resp => this.myPosts = resp);
  }

  getAllPosts()
  {
    this.router.navigate(['/home']);
  }
}
