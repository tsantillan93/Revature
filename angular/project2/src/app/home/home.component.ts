import { Component, OnInit } from '@angular/core';
import { PostService } from '../post.service';

import { Post } from '../post';
import { Router } from '../../../node_modules/@angular/router';
import { PostFilterPipe } from '../post-filter.pipe';
import { Observable } from '../../../node_modules/rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [PostFilterPipe]
})

export class HomeComponent implements OnInit {
  public posts: Post[];
  public allPosts: Post[];
  public searchPostsArray: Post[];
  public searchBar: string;
  public maxPrice: number;

  constructor(private postService: PostService, private router: Router, private pipe: PostFilterPipe) { }

  ngOnInit() {
    this.postService.getPosts().subscribe(resp => this.posts = resp);
    this.postService.getPosts().subscribe(resp => this.allPosts = resp);
    this.searchBar = '';
    this.maxPrice = 0;
  }

  getMyPosts()
  {
    this.router.navigate(['/myPosts']);
  }

  viewPost(id: number) {
    this.router.navigate(['post/' + id]);
  }

  searchAndFilterPosts():Post[]
  {
     if(this.searchBar != '' || ((this.maxPrice != null) || (this.maxPrice != 0)))
     {
      this.posts = this.pipe.transform(this.allPosts, this.searchBar, this.maxPrice);
      // if (this.maxPrice != 0 && this.maxPrice != null)
      // {
      //   this.posts = this.filterPosts();
      // }
     }
    
     else
     {
      this.posts = this.allPosts;
     }

    return this.posts;
  }

  filterPosts():Post[]
  {
    console.log("Received the filter");
    if(this.maxPrice != null){
     // console.log(this.maxPrice.toString());
      this.posts = this.pipe.transform(this.allPosts, this.maxPrice.toString());
    }
    else
    {
      this.posts = this.allPosts;
    }
      return this.posts;
  }

}