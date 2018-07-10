import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserserviceService } from 'src/app/userservice.service';
import { PostService } from 'src/app/post.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Post } from 'src/app/post';
import { User } from 'src/app/user';
@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {
  registrationForm: FormGroup;
  private post: Post;
  private startDate: string;
  private endDate: string;
  private latitude: number;
  private longitude: number;
  private submitted = false;
  constructor(private userService: UserserviceService, private postService: PostService,
              private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    if (!this.userService.getUser) {
      this.router.navigate(['/login']);
    }
    this.registrationForm = this.formBuilder.group
    ({
      title : ['', Validators.required],
      description : ['tell me something about what youre selling.'],
      price : ['', [Validators.required]],

    });
  }

  addPost() {
    console.log('adding a Post');
    this.submitted = true;
    this.post = new Post();
    this.post.id = 0;
    this.post.owner = this.userService.getUser();
    this.post.title = this.registrationForm.controls.title.value;
    this.post.startDate = this.startDate;
    this.post.endDate = this.endDate;
    this.post.description = this.registrationForm.controls.description.value;
    this.post.latitude = this.latitude;
    this.post.longitude = this.longitude;
    this.post.price = this.registrationForm.controls.price.value;

    this.postService.add(this.post).subscribe(
      object => {
        this.router.navigate(['/home']);
      }
    );
  }

}
