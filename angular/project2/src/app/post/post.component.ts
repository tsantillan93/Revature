import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';

import { Post } from 'src/app/post';
import { PostService } from 'src/app/post.service';
import { UserserviceService } from 'src/app/userService.service';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input() selectedPost: Post;
  constructor(
    private userServiceService: UserserviceService,
    private postService: PostService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location
  ) { }
  

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');

    if (id) {
      this.postService.get(id).subscribe(
          post => this.selectedPost = post);
    }
  }


}
