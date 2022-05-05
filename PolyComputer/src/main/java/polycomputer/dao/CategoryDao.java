package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	List<Category> findByCategoryNameContaining(String name);
}
