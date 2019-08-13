import { Component, OnInit } from '@angular/core';
import { Router, Event, NavigationEnd } from '@angular/router';
import { MoviesService } from '../movies.services';
import { Movie } from '../model/Movie';


@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent  {

  movies : Movie[]
  progressFlag: boolean

  constructor( public router: Router,public service:MoviesService ) {
    this.progressFlag = true
    service.getMovies().subscribe((data: Movie[]) => {
      
      this.movies = data
      this.progressFlag = false
      console.log(data);
    })
    }
  
 }