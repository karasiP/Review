import { Component, OnInit } from '@angular/core';
import { ReviewService } from 'src/app/review.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { throwMatDialogContentAlreadyAttachedError } from '@angular/material';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  private static reviewID:any;
  users: Array<any>;
  userIdSelect: number = 0;
  items: Array<any>;
  itemIdSelect: number = 0;
  rating: number = 0;
  starCount: number;
  color: string;
  comments: string = '';
  proposals: Array<any>;
  propIdSelect: number = 0;
  review:object;


  constructor(private service: ReviewService, private httpClient: HttpClient, private router: Router) {

  }

  ngOnInit() {
    this.getAllUser();
    this.getItem();
    this.getProposal();

  }

  getAllUser() {
    this.service.getAllUser().subscribe(data => {
      this.users = data;
    })
  }

  getItem() {
    this.service.getItem().subscribe(data => {
      this.items = data;
    })
  }

  getProposal() {
    this.service.getProposal().subscribe(data => {
      this.proposals = data;
    })
  }

  test(data: any) {
    console.log(data);
  }
  onRatingChanged(rating) {
    console.log(rating);
    this.rating = rating;
  }

  public static getReviewId(): number {
    return this.reviewID;
  }

  save() {
    let reviewID: any;
    if (this.userIdSelect === 0 || this.itemIdSelect === 0 || this.propIdSelect === 0 || this.rating === 0 || this.comments === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.service.postReview(this.userIdSelect,this.itemIdSelect,this.propIdSelect,this.rating,this.comments).subscribe(data => {
          console.log(data);
          ReviewComponent.reviewID = data.review_id;
          console.log('PUT Request is successful', data);
          this.router.navigate(['reviewshow']);
        },
          error => {
            console.log('Error', error);
          }
        );
    }
  }
}
