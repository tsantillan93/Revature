import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';

import { Post } from 'src/app/post';
import { Bid } from 'src/app/bid';
import { BidInfo } from 'src/app/bidInfo';
import { PostService } from 'src/app/post.service';
import { UserserviceService } from 'src/app/userservice.service';
import { BidService } from 'src/app/bid.service';
import { FormBuilder, FormGroup, Validators } from '../../../node_modules/@angular/forms';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input() selectedPost: Post;
  private bidForm: FormGroup;
  private info: BidInfo;
  private bid: Bid;
  private lat = 39.636630;
  private long = -79.954601;
  private distance: number;

  constructor(
    private postService: PostService,
    private userService: UserserviceService,
    private bidService: BidService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) {

      this.postService.get(id).
      pipe(first()).subscribe(
        post => {
          this.selectedPost = post;
          this.setDistance();
        },
        error => {
          alert('Something went Wrong!');
          this.router.navigate(['/home']);
        }
      );

      this.postService.getInfo(id).
        pipe(first()).subscribe(
          bidInfo => {
            if (bidInfo) {
              if (bidInfo.maxBid) {
                this.bidForm = this.formBuilder.group({
                  bid : [bidInfo.maxBid.amount, Validators.min(bidInfo.maxBid.amount + 1)]
                });
                console.log(this.bidForm);
              } else {
                this.bidForm = this.formBuilder.group({
                  bid : [bidInfo.minAmount, Validators.min(bidInfo.minAmount + 1)]
                });
                console.log(this.bidForm);
              }
            }
            this.info = bidInfo;
          },
          error => {
            alert('Something went Wrong!');
            this.router.navigate(['/home']);
          }
        );
    }
  }

  placeBid() {
    if (this.bidForm.controls.bid.value > this.selectedPost.price) {
      this.bid = new Bid();
      this.bid.id = 0;
      this.bid.post = this.selectedPost.id;
      console.log(this.userService.getUser());
      this.bid.user = this.userService.getUser();
      this.bid.amount = this.bidForm.controls.bid.value;

      this.bidService.add(this.bid).
      pipe(first()).subscribe(
        bid => {
          this.info.maxBid = bid;
          this.postService.updateInfo(this.info).
          pipe(first()).subscribe(
            data => {
              this.selectedPost.price = bid.amount;
              this.postService.update(this.selectedPost).
              pipe(first()).subscribe(
                  data2 => {
                    alert('Successfully updated');
                    this.router.navigate(['/post/' + this.route.snapshot.paramMap.get('id')]);
                  },
                  error => {
                    alert('Something went wrong in post');
                  });
          },
            error => {
              alert('Something went wrong in info');
            });
        },
        error => {
          alert('Something went Wrong in bid');
          // this.router.navigate(['/home']);
        }
      );
    } else {
      alert('Bid must be greater than current value');
    }
  }

  setDistance() {
    this.lat = this.getRandomInRange(39.5, 39.7);
    this.long = this.getRandomInRange(-80, -79.8);

    console.log(this.lat + ' ' + this.long);
    this.distance = Math.sqrt(Math.pow((this.lat - this.selectedPost.latitude), 2) + Math.pow((this.long - this.selectedPost.longitude), 2));
  }

  getRandomInRange(from, to) {
    return (Math.random() * (to - from) + from).toFixed(6) * 1;
    // .toFixed() returns string, so ' * 1' is a trick to convert to number
  }
}
