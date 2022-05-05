package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.BrandDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Brand;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.BrandService;
import polycomputer.service.AccountService;


@Service
public class BrandServiceImpl implements BrandService {
@Autowired
BrandDao dao;
@Override
public List<Brand> findAll() {
	
	return dao.findAll();
}
@Override
public Brand findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Brand create(Brand brand) {
	return dao.save(brand);
}
@Override
public Brand update(Brand brand) {
	return dao.save(brand);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
