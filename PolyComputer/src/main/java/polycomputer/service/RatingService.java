package polycomputer.service;

import java.util.List;

import polycomputer.entity.Rating;

public interface RatingService {

	void deleteById(Integer id);

	Rating update(Rating rating);

	Rating create(Rating rating);

	Rating findById(Integer id);

	List<Rating> findAll();

}
