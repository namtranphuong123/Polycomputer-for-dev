package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.RatingDao;
import polycomputer.entity.Rating;
import polycomputer.service.RatingService;


@Service
public class RatingServiceImpl implements RatingService {
@Autowired
RatingDao dao;
@Override
public List<Rating> findAll() {
	
	return dao.findAll();
}
@Override
public Rating findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Rating create(Rating rating) {
	return dao.save(rating);
}
@Override
public Rating update(Rating rating) {
	return dao.save(rating);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
