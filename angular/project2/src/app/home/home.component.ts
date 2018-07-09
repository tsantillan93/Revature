import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

import { Post } from '../post';
import { first } from '../../../node_modules/rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public posts: Post[];
  width  = 600;
  height = 400;
  type = 'column2d';
  dataFormat = 'json';

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postService.getPosts().subscribe(resp => this.posts = resp);
  }
}