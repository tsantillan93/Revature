import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserserviceService } from 'src/app/userservice.service';
import { PostService } from 'src/app/post.service';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { Post } from 'src/app/post';
import { BidInfo } from 'src/app/bidInfo';
@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {
  registrationForm: FormGroup;
  private post: Post;
  private info: BidInfo;
  private isBidPost = false;
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
      description : ['tell me something about what youre selling', Validators.maxLength(300)],
      price : ['', [Validators.required]],
      startDate : ['', [Validators.required]],
      endDate : ['', [Validators.required]],
    });
  }

  addPost() {
    console.log('adding a Post');
    this.submitted = true;
    this.post = new Post();
    this.post.id = 0;
    this.post.owner = this.userService.getUser();
    this.post.title = this.registrationForm.controls.title.value;
    this.post.startDate = this.registrationForm.controls.startDate.value;
    this.post.endDate = this.registrationForm.controls.endDate.value;
    this.post.description = this.registrationForm.controls.description.value;
    this.post.latitude = this.getRandomInRange(39.5, 39.7);
    this.post.longitude = this.getRandomInRange(-80, -79.8);
    this.post.price = this.registrationForm.controls.price.value;

    this.postService.add(this.post).subscribe(
      object => {
        this.router.navigate(['/myPosts']);
      }
    );
  }

  addBidPost() {
    console.log('adding a BidPost');
    this.submitted = true;
    this.post = new Post();
    this.post.id = 0;
    this.post.owner = this.userService.getUser();
    this.post.title = this.registrationForm.controls.title.value;
    this.post.startDate = this.registrationForm.controls.startDate.value;
    this.post.endDate = this.registrationForm.controls.endDate.value;
    this.post.description = this.registrationForm.controls.description.value;
    this.post.latitude = this.getRandomInRange(39.5, 39.7);
    this.post.longitude = this.getRandomInRange(-80, -79.8);
    this.post.price = this.registrationForm.controls.price.value;

    this.postService.add(this.post).
    pipe(first()).subscribe(
      post => {
        this.info = new BidInfo();
        this.info.id = post.id;
        this.info.maxBid = null;
        this.info.minAmount = this.registrationForm.controls.price.value;

        this.postService.addInfo(this.info).
        pipe(first()).subscribe(
          bidInfo => {
            this.router.navigate(['/myPosts']);
          },
          error => {
            alert('Something went Wrong!');
            this.router.navigate(['/addPost']);
          }
        );
      },
      error => {
        alert('Something went Wrong!');
        this.router.navigate(['/addPost']);
      }
    );
  }

  isBid() {
    this.isBidPost = !this.isBidPost;
  }

  getRandomInRange(from, to) {
    return (Math.random() * (to - from) + from).toFixed(6) * 1;
    // .toFixed() returns string, so ' * 1' is a trick to convert to number
  }

}
