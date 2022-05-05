package polycomputer.service;

import java.util.List;

import polycomputer.entity.CPU;

public interface CPUService {

	void deleteById(Integer id);

	CPU update(CPU CPU);

	CPU create(CPU CPU);

	CPU findById(Integer id);

	List<CPU> findAll();

	

}
