import { Component, OnInit, Input} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, pipe, of } from 'rxjs';
import { first } from 'rxjs/operators';
import { map } from 'rxjs/operators';

import { Post } from '../post';
import { PostService} from 'src/app/post.service';
import { enableDebugTools } from '../../../node_modules/@angular/platform-browser';
import { Form, FormGroup, FormControl } from '../../../node_modules/@angular/forms';
@Component({
  selector: 'app-mypost',
  templateUrl: './mypost.component.html',
  styleUrls: ['./mypost.component.css']
})
export class MypostComponent implements OnInit {

  @Input() openPost: Post;
  private myform: FormGroup;

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getMyPost();
  }
  getMyPost() {
     const id = +this.route.snapshot.paramMap.get('id');

   if (id) {
     this.postService.get(id).subscribe(
         post => this.openPost = post);
     }
   }

   edit(): void {
    console.log('Inside edit component: ' + this.openPost);
    this.postService.update(this.openPost).
    pipe(first()).subscribe(
      data => {
        alert('Successfully updated info');

        this.router.navigate(['/home']);
      },
      error => {
        alert('Something went wrong');
      });
  }
   enable(): void {
     console.log('Edditing Your Post');
    //  document.getElementById('title').disabled = false;
    //  document.getElementById('description').disabled = false;
    //  document.getElementById('price').disabled = false;
    //  document.getElementById('edit').style.opacity = 0;

   }
}
