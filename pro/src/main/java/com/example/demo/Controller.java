package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })

public class Controller {

	@Autowired
	private MovieReviewRepository reviewRepo;

	@Autowired
	private MoviesRepository movieRepo;

	@Autowired
	private UsersRepository userRepo;

	@PostMapping("/signup")
	public User signUp(HttpServletRequest req, @RequestBody User user) {

		User result = null;
		try {
			result = userRepo.save(user);
			HttpSession session = req.getSession();
			session.setAttribute("email", result.getEmail());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

	}

	@PostMapping("/signin")
	public Status signIn(HttpServletRequest req, @RequestBody User user) {
		User temp = userRepo.findByEmail(user.getEmail());

		if (temp.getPassword().equals(user.getPassword())) {
			HttpSession session = req.getSession();
			session.setAttribute("email", temp.getEmail());
			return new Status(true);
		}
		return new Status(false);
	}

	@GetMapping("/movie/{id}")
	public Movie getMoviesById(HttpServletRequest req, @PathVariable int id) {

		return movieRepo.findById(id).get();

	}

	@GetMapping("/reviews/{id}")
	public List<MovieReview> getMovieReviewsById(HttpServletRequest req, @PathVariable int id) {

		Movie movie = new Movie();
		movie.setmId(id);

		return reviewRepo.findByMovie(movie);

	}

	@GetMapping("/movie/all")
	public List<Movie> getMovies(HttpServletRequest req) {

		List<Movie> movies = new ArrayList<Movie>();
		Iterable<Movie> iterable = movieRepo.findAll();
		for (Movie movie : iterable) {
			movies.add(movie);
		}
		return movies;
	}

	@GetMapping("/review/all")
	public List<MovieReview> getReviews(HttpServletRequest req) {

		List<MovieReview> reviews = new ArrayList<MovieReview>();
		Iterable<MovieReview> iterable = reviewRepo.findAll();
		for (MovieReview movieReview : iterable) {
			reviews.add(movieReview);
		}
		return reviews;
	}

	@PostMapping("/movie/save")
	public Movie saveMovie(HttpServletRequest req, @RequestBody Movie movie) {
		movie = movieRepo.save(movie);
		return movie;
	}

	@PostMapping("/review/save")
	public MovieReview saveReview(HttpServletRequest req, @RequestBody MovieReview movieReview) {

		System.out.println(movieReview);
		movieReview.setUser(new User());
		movieReview.getUser().setuId(movieReview.getUfk());
		movieReview.setMovie(new Movie());
		movieReview.getMovie().setmId(movieReview.getFk());
		return reviewRepo.save(movieReview);
	}

	@DeleteMapping("/delete/{mId}")
	public Status deleteMovie(HttpServletRequest req, @PathVariable Integer mId) {

		movieRepo.deleteById(mId);
		return new Status(true);
	}

	@DeleteMapping("/delete/{mId}/{rId}")
	public Status deleteReview(HttpServletRequest req, @PathVariable Integer rId) {

		reviewRepo.deleteById(rId);
		return new Status(true);
	}


	@PostMapping("/signout")
	public Status logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("email") != null) {
			session.invalidate();
			return new Status(true);
		}
		return new Status(false);
	}

}
