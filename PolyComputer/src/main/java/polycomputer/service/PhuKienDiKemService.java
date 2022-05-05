package polycomputer.service;

import java.util.List;

import polycomputer.entity.PhuKienDiKem;

public interface PhuKienDiKemService {

	void deleteById(Integer id);

	PhuKienDiKem update(PhuKienDiKem PhuKienDiKem);

	PhuKienDiKem create(PhuKienDiKem PhuKienDiKem);

	PhuKienDiKem findById(Integer id);

	List<PhuKienDiKem> findAll();

}
