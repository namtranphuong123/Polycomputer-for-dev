package polycomputer.service;

import java.util.List;

import polycomputer.entity.HeDieuHanh;

public interface HeDieuHanhService {

	void deleteById(Integer id);

	HeDieuHanh update(HeDieuHanh heDieuHanh);

	HeDieuHanh create(HeDieuHanh heDieuHanh);

	HeDieuHanh findById(Integer id);

	List<HeDieuHanh> findAll();

}
