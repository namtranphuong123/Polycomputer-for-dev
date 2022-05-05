package polycomputer.service;

import java.util.List;

import polycomputer.entity.Images;

public interface ImageService {

	void deleteById(Integer id);

	Images update(Images image);

	Images create(Images image);

	Images findById(Integer id);

	List<Images> findAll();

	List<Images> findByProductId(Integer productId);

}
