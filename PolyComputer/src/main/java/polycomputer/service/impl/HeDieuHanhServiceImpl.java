package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.dao.GiftDao;
import polycomputer.dao.HeDieuHanhDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.entity.Gift;
import polycomputer.entity.HeDieuHanh;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;
import polycomputer.service.GiftService;
import polycomputer.service.HeDieuHanhService;


@Service
public class HeDieuHanhServiceImpl implements HeDieuHanhService {
@Autowired
HeDieuHanhDao dao;
@Override
public List<HeDieuHanh> findAll() {
	
	return dao.findAll();
}
@Override
public HeDieuHanh findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public HeDieuHanh create(HeDieuHanh heDieuHanh) {
	return dao.save(heDieuHanh);
}
@Override
public HeDieuHanh update(HeDieuHanh heDieuHanh) {
	return dao.save(heDieuHanh);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
