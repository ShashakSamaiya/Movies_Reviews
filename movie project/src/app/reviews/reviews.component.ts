import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../model/Movie';
import { MoviesService } from '../movies.services';
import { MovieReview } from '../model/MovieReview';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent implements OnInit {
  movie: Movie

  constructor(public ar: ActivatedRoute, public service: MoviesService) {
    var id: any = this.ar.snapshot.paramMap.get('id')
    this.service.getMovie(id).subscribe((data: Movie) => {
      this.movie = data
    })

    service.getReviews(id).subscribe((data: MovieReview[]) => {
      this.service.reviews = data
    })
  }
  ngOnInit() {
  }


}
