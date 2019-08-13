package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieReviewRepository extends CrudRepository<MovieReview, Integer> {

	List<MovieReview> findByMovie(Movie movie);

}
