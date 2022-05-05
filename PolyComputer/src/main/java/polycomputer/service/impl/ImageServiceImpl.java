package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CategoryDao;
import polycomputer.dao.AccountDao;
import polycomputer.dao.GiftDao;
import polycomputer.dao.ImageDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.Category;
import polycomputer.entity.Account;
import polycomputer.entity.Gift;
import polycomputer.entity.Images;
import polycomputer.service.BanPhimService;
import polycomputer.service.CategoryService;
import polycomputer.service.AccountService;
import polycomputer.service.GiftService;
import polycomputer.service.ImageService;


@Service
public class ImageServiceImpl implements ImageService {
@Autowired
ImageDao dao;
@Override
public List<Images> findAll() {
	
	return dao.findAll();
}
@Override
public Images findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Images create(Images image) {
	return dao.save(image);
}
@Override
public Images update(Images image) {
	return dao.save(image);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}
@Override
public List<Images> findByProductId(Integer productId) {
	return dao.findByProductId(productId);
}



}
