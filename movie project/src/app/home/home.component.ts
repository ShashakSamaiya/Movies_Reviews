import { AuthenticateService } from './../authenticate.service';
import { Router, Event, NavigationEnd } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { MoviesService } from './../movies.services';
import { Movie } from '../model/Movie';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  movies: Movie[]
  progressFlag: boolean

  response: any;
  constructor( public router: Router,public authService: AuthenticateService,public service: MoviesService) {
   
    var sub = router.events.subscribe((event: Event) => {
      if (event instanceof NavigationEnd && !authService.loginStatus) {
        router.navigateByUrl('/signin')
      }
    })
      this.progressFlag = true
      service.getMovies().subscribe((data: Movie[]) => {
      this.movies = data
      this.progressFlag = false
      console.log(data);
    })
  }

  //  movieCopy(movie:Movie){
  //   var obj: Movie = new Movie()
  //   obj.mId = movie.mId
  //   obj.movieName = movie.movieName
  //   obj.cast = movie.cast
  //   obj.duration = movie.duration

  //   return obj
  // }

  ngOnInit() {
  }
}

// }
// 
// 