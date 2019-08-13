import { Movie } from './model/Movie';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MovieReview } from './model/MovieReview';

@Injectable({
  providedIn: 'root'
})

export class MoviesService {

  public movies: Movie[]
  public reviews: MovieReview[]

  constructor(public http: HttpClient) {
    this.movies = []
    this.reviews = []
  }

  getMovies() {
    return this.http.get('http://localhost:3003/movie/all')
  }

  getMovie(id: number) {
    return this.http.get('http://localhost:3003/movie/' + id)
  }

  saveMovie(movie: Movie) {
    return this.http.post('http://localhost:3003/movie/save', movie)
  }

  deleteMovie(mId: number) {
    return this.http.delete('http://localhost:3003/delete/{mId}' + mId)
  }

  getReviews(id) {
    return this.http.get('http://localhost:3003/reviews/' + id)
  }

  saveReview(movieReview: MovieReview) {
    return this.http.post('http://localhost:3003/review/save', movieReview)
  }

  deleteMovieReview(rId: number) {
    return this.http.delete('http://localhost:3003/delete/{rId}' + rId)
  }

}