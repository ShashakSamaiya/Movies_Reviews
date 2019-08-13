package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "reviews")
public class MovieReview{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rId;

	@Transient
	private Integer fk;
	
	@Transient
	private Integer ufk;
    private String rating;
	private String review;  
	
	@ManyToOne
	private Movie movie;
	
	@ManyToOne
	private User user;
	
	public MovieReview() {
		// TODO Auto-generated constructor stub
	}

	public MovieReview(User user,Movie movie,Integer rId, String rating, String review) {
		super();
		this.user = user;
		this.movie = movie;
		this.rId = rId;
		this.rating = rating;
		this.review = review;
		
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getFk() {
		return fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	public Integer getUfk() {
		return ufk;
	}

	public void setUfk(Integer ufk) {
		this.ufk = ufk;
	}
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	@JsonIgnore
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "MovieReview [movie" + movie + "user " + user + " rating=" + rating +
				", review=" + review  + ",rId= " + rId +"]";
	}
	
	
}