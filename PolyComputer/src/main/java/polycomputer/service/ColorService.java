package polycomputer.service;

import java.util.List;

import polycomputer.entity.Color;

public interface ColorService {

	void deleteById(Integer id);

	Color update(Color color);

	Color create(Color color);

	Color findById(Integer id);

	List<Color> findAll();

	

}
