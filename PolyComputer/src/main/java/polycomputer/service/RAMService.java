package polycomputer.service;

import java.util.List;

import polycomputer.entity.RAM;

public interface RAMService {

	void deleteById(Integer id);

	RAM update(RAM ram);

	RAM create(RAM ram);

	RAM findById(Integer id);

	List<RAM> findAll();

}
