import { Component, OnInit, Input } from '@angular/core';
import { MovieReview } from './../model/MovieReview';
import { MoviesService } from '../movies.services';
import { Status } from '../model/Status';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  newMovieReview: MovieReview

  @Input()
  mId: number

  constructor(public service: MoviesService) {
    this.newMovieReview = new MovieReview()
  }

  ngOnInit() {
  }

  saveReview(addForm) {
    this.newMovieReview.ufk = 510
    this.newMovieReview.fk = this.mId

    this.service.saveReview(this.newMovieReview)
      .subscribe((data: MovieReview) => {
        console.log(data)
        this.service.reviews.unshift(data)
        addForm.form.markAsPristine()
        // this.newMovieReview = new MovieReview()
      })
  }

  delete(rId: number, i: number) {
    this.service.deleteMovieReview(rId)
      .subscribe((data: Status) => {
        if (data.queryStatus) {
          this.service.reviews.splice(i, i)
        }
      })
  }

}
