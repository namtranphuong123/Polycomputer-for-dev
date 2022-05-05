package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.dao.LuuTruDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.entity.LuuTru;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;
import polycomputer.service.LuuTruService;


@Service
public class LuuTruServiceImpl implements LuuTruService {
@Autowired
LuuTruDao dao;
@Override
public List<LuuTru> findAll() {
	
	return dao.findAll();
}
@Override
public LuuTru findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public LuuTru create(LuuTru luuTru) {
	return dao.save(luuTru);
}
@Override
public LuuTru update(LuuTru luuTru) {
	return dao.save(luuTru);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
