package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;


@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
CategoryDao dao;
@Override
public List<Category> findAll() {
	
	return dao.findAll();
}
@Override
public Category findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Category create(Category category) {
	return dao.save(category);
}
@Override
public Category update(Category category) {
	return dao.save(category);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
