import { Component, OnInit } from '@angular/core';
import { ReviewService } from 'src/app/review.service';
import { ReviewComponent } from 'src/app/review/review.component';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reviewshow',
  templateUrl: './reviewshow.component.html',
  styleUrls: ['./reviewshow.component.css']
})
export class ReviewshowComponent implements OnInit {

  private sub: any;
  private id: number;

  username:string;
  comment:string;
  rating:number;
  reviewdate:Date;
  formatdate:string;
  reviewId:number;


  constructor(private service:ReviewService,private router: Router, private rout: ActivatedRoute) {

   }

  ngOnInit() {



    this.getReviewShow();


  }
  getReviewShow(){

    this.service.getReviewID(ReviewComponent.getReviewId()).subscribe(data =>{
      this.username = data.user.username;
      this.comment = data.comments;
      this.rating = data.rating;
      this.reviewdate = data.reviewdate;
      var splitted = this.reviewdate.toString().split("T");
      this.formatdate = splitted[0];
      console.log(data,this.username)
      console.log(data,this.comment)
      console.log(data,this.rating)
    },error =>{

    });
  }
}
