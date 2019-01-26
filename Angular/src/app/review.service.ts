import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ReviewComponent} from './review/review.component';

@Injectable()
export class ReviewService {

  constructor(private http: HttpClient) {
  }
  public API = '//localhost:8080';

  getAllreviewshow(): Observable<any>{
    return this.http.get('//localhost:8080/review');
  }

  getReviewID(reviewId:number) : Observable<any>{
    return this.http.get('//localhost:8080/review/'+reviewId);
  }

  getAllUser() : Observable<any>{
    return this.http.get('//localhost:8080/User');
  }

   getItem() : Observable<any>{
    return this.http.get('//localhost:8080/Item')
  }
   getProposal(): Observable<any>{
    return this.http.get('//localhost:8080/Proposal')
  }
  postReview(userIdSelect:number,itemIdSelect:number,propIdSelect:number,rating:number,comments:string):Observable<any>{
    return  this.http.post("//localhost:8080/review/create/"+userIdSelect+"/"+itemIdSelect+"/"+propIdSelect+"/"+rating+"/"+comments,this.getReviewID);
  }
<mat-form-field class="full-width-input" style="width: 40% ;margin: 0 5% 0 5%; ">
          <input matInput [(ngModel)]="birthDayProfile" [matDatepicker]="picker1" [ngModelOptions]="{standalone: true}"
            placeholder="Birth Day" required>
          <mat-datepicker-toggle matSuffix [for]="picker1"></mat-datepicker-toggle>
          <mat-datepicker #picker1></mat-datepicker>
        </mat-form-field>

}
