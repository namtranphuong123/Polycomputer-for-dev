package polycomputer.service;

import java.util.List;

import polycomputer.entity.Brand;

public interface BrandService {

	void deleteById(Integer id);

	Brand update(Brand banPhim);

	Brand create(Brand brand);

	Brand findById(Integer id);

	List<Brand> findAll();

}
