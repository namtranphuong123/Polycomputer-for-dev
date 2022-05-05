package polycomputer.service;

import java.util.List;

import polycomputer.entity.BanPhim;
import polycomputer.entity.CPUSerie;
import polycomputer.entity.CPUSerie;

public interface CPUSerieService {

	void deleteById(Integer id);

	CPUSerie update(CPUSerie CPUSerie);

	CPUSerie create(CPUSerie CPUSerie);

	CPUSerie findById(Integer id);

	List<CPUSerie> findAll();

	
	List<CPUSerie> findByCpuSerieNameContaining(String name);
}