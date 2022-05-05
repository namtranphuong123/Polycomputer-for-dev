package polycomputer.service;

import java.util.List;

import polycomputer.entity.LuuTru;

public interface LuuTruService {

	void deleteById(Integer id);

	LuuTru update(LuuTru luuTru);

	LuuTru create(LuuTru luuTru);

	LuuTru findById(Integer id);

	List<LuuTru> findAll();

}
