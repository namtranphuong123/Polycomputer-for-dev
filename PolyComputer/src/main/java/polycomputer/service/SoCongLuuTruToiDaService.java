package polycomputer.service;

import java.util.List;

import polycomputer.entity.SoCongLuuTruToiDa;

public interface SoCongLuuTruToiDaService {

	void deleteById(Integer id);

	SoCongLuuTruToiDa update(SoCongLuuTruToiDa soCongLuuTruToiDa);

	SoCongLuuTruToiDa create(SoCongLuuTruToiDa soCongLuuTruToiDa);

	SoCongLuuTruToiDa findById(Integer id);

	List<SoCongLuuTruToiDa> findAll();

}
