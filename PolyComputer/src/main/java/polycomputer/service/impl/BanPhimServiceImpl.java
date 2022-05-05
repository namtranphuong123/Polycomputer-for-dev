package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.AccountService;


@Service
public class BanPhimServiceImpl implements BanPhimService {
@Autowired
BanPhimDao dao;
@Override
public List<BanPhim> findAll() {
	
	return dao.findAll();
}
@Override
public BanPhim findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public BanPhim create(BanPhim banPhim) {
	return dao.save(banPhim);
}
@Override
public BanPhim update(BanPhim banPhim) {
	return dao.save(banPhim);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
