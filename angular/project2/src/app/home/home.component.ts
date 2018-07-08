import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

import { Post } from '../post';

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

  getPostDataSource(): any {
    const dataSource = {
      'chart': {
        'caption': 'All Posts',
        'subCaption': 'Posts in Nearby',
        'numberPrefix': '$',
        'theme': 'ocean'
      },
      'data': null
    };
    dataSource.data = this.getPostData();
    console.log(dataSource);
    return dataSource;
  }
  getPostData(): any[] {
    const data = [];
    if (!this.posts) {
      console.log("No posts found.");
      return data;
    }
    this.posts.forEach(p => {
      data.push({
        'label': 'Post ID',
        'value': p.id
        },
        {
        'label': 'Post Title',
        'value': p.title
        },
        {
        'label': 'Post Description',
        'value': p.description
        },
        {
        'label': 'Post Price',
        'value': p.price
        },
        {
        'label': 'Post Start Date',
        'value': p.startDate
        },
        {
        'label': 'Post End Date',
        'value': p.endDate
        }
      );
    });
    console.log(data);
    return data;
  }

}
