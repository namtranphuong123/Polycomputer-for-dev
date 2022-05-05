package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.dao.GiftDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.entity.Gift;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;
import polycomputer.service.GiftService;


@Service
public class GiftServiceImpl implements GiftService {
@Autowired
GiftDao dao;
@Override
public List<Gift> findAll() {
	
	return dao.findAll();
}
@Override
public Gift findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Gift create(Gift gift) {
	return dao.save(gift);
}
@Override
public Gift update(Gift gift) {
	return dao.save(gift);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
