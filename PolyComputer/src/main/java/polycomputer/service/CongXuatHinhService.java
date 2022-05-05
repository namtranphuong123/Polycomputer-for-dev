package polycomputer.service;

import java.util.List;

import polycomputer.entity.CongXuatHinh;

public interface CongXuatHinhService {

	void deleteById(Integer id);

	CongXuatHinh update(CongXuatHinh congXuatCauHinh);

	CongXuatHinh create(CongXuatHinh congXuatCauHinh);

	CongXuatHinh findById(Integer id);

	List<CongXuatHinh> findAll();

}
