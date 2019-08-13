package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uId;
	@Column(unique = true)
	private String email;
	private String userName;
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MovieReview> movieReview;

	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Integer uId, String email, String userName, String password, List<MovieReview> movieReview) {
		super();
		this.uId = uId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.movieReview = movieReview;
	}


	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<MovieReview> getMovieReview() {
		return movieReview;
	}

	public void setMovieReview(List<MovieReview> movieReview) {
		this.movieReview = movieReview;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}

}
