import { Component, OnInit } from '@angular/core';

import { PostService } from '../post.service';

import { Post } from '../post';

@Component({
  selector: 'app-my-posts',
  templateUrl: './my-posts.component.html',
  styleUrls: ['./my-posts.component.css']
})
export class MyPostsComponent implements OnInit {
  public myPosts: Post[];

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postService.getMyPosts().subscribe(resp => this.myPosts = resp);
  }

}
