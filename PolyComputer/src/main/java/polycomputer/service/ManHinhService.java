package polycomputer.service;

import java.util.List;

import polycomputer.entity.ManHinh;

public interface ManHinhService {

	void deleteById(Integer id);

	ManHinh update(ManHinh manHinh);

	ManHinh create(ManHinh manHinh);

	ManHinh findById(Integer id);

	List<ManHinh> findAll();

}
