package polycomputer.service;

import java.util.List;

import polycomputer.entity.BanPhim;

public interface BanPhimService {

	void deleteById(Integer id);

	BanPhim update(BanPhim banPhim);

	BanPhim create(BanPhim banPhim);

	BanPhim findById(Integer id);

	List<BanPhim> findAll();

}
