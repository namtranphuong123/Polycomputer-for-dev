package polycomputer.service;

import java.util.List;

import polycomputer.entity.Category;

public interface CategoryService {

	void deleteById(Integer id);

	Category update(Category category);

	Category create(Category category);

	Category findById(Integer id);

	List<Category> findAll();



}
