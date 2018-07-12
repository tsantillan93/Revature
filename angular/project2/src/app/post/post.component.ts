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
      this.postService.get(id).subscribe(
          post => this.selectedPost = post);

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
    this.bid = new Bid();
    this.bid.id = 0;
    this.bid.post = this.selectedPost.id;
    this.bid.user = this.userService.getUser();
    // this.bid.amount =

    this.bidService.add(this.bid).
    pipe(first()).subscribe(
      bid => {
        this.info.maxBid = bid;
        this.postService.updateInfo(this.info);
        this.selectedPost.price = bid.amount;
        this.postService.update(this.selectedPost);
        this.router.navigate(['/post/' + this.route.snapshot.paramMap.get('id')]);
      },
      error => {
        alert('Something went Wrong!');
        this.router.navigate(['/home']);
      }
    );
  }


}
