package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Brand;

@Repository
public interface BrandDao extends JpaRepository<Brand, Integer>{
	List<Brand> findByBrandNameContaining(String name);
}
