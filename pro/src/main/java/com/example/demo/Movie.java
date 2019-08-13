package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mId;

	@Column(unique = true)
	private String movieName;
	private String cast;
	private String duration;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieReview> movieReview;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer mId, String movieName, String cast, String duration, List<MovieReview> movieReview) {
		super();
		this.mId = mId;
		this.movieName = movieName;
		this.cast = cast;
		this.duration = duration;
		this.movieReview = movieReview;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public List<MovieReview> getMovieReview() {
		return movieReview;
	}

	public void setMovieReview(List<MovieReview> movieReview) {
		this.movieReview = movieReview;
	}

	@Override
	public String toString() {
		return "Movie [mId=" + mId + ", movieName=" + movieName + ", cast=" + cast + ", duration=" + duration
				+  "]";
	}

}