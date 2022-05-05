package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.dao.ManHinhDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.entity.ManHinh;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;
import polycomputer.service.ManHinhService;


@Service
public class ManHinhServiceImpl implements ManHinhService {
@Autowired
ManHinhDao dao;
@Override
public List<ManHinh> findAll() {
	
	return dao.findAll();
}
@Override
public ManHinh findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public ManHinh create(ManHinh manHinh) {
	return dao.save(manHinh);
}
@Override
public ManHinh update(ManHinh manHinh) {
	return dao.save(manHinh);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
