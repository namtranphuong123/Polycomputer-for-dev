package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import polycomputer.dao.ProductDao;
import polycomputer.entity.Product;
import polycomputer.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

@Autowired
ProductDao dao;

@Override
public List<Product> top10newforBrand(Integer cid) {
	return dao.top10newforBrand(cid);
}

@Override
public List<Object[]> top3ProducthotoderofBrand(Integer cid) {
	return dao.top3ProducthotoderofBrand(cid);
}

@Override
public List<Product> findByAll(Integer cid, Integer cat, Integer col, Integer cpu, Integer chipdh, Integer ram) {
	return dao.findByAll(cid, cat, col, cpu, chipdh, ram);
}

@Override
public List<Product> findByColorId(Integer col) {
	return dao.findByColorId(col);
}

@Override
public List<Product> findByProductNameContaining(String name) {
	return dao.findByProductNameContaining(name);
}

@Override
public List<Product> findByCpuId(Integer cpu) {
	return dao.findByCpuId(cpu);
}

@Override
public List<Product> findByChipdohoaId(Integer chipdh) {
	return dao.findByChipdohoaId(chipdh);
}

@Override
public List<Product> findByRamId(Integer ram) {
	return dao.findByRamId(ram);
}

@Override
public List<Product> findAll() {
	
	return dao.findAll();
}

@Override
public List<Product> top5khuyen() {
	return dao.top5khuyen();
}

@Override
public Product findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Product create(Product Product) {
	return dao.save(Product);
}
@Override
public Product update(Product Product) {
	return dao.save(Product);


}

@Override
public List<Product> findByBrandId(Integer cid) {
	return dao.findByBrandId(cid);
}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}
@Override
public List<Product> findByCategoryId(Integer cid) {
	return dao.findByCategoryId(cid);
}








  @Override public Page<Product> findByproductNameContaining(String name, Pageable
  pageable) { // TODO Auto-generated method stub return
  return dao.findByProductNameContaining(name, pageable); }
 










@Override
public List<Object[]> top10HotOrder() {
	return dao.top10HotOrder();
}
@Override
public List<Product> top10new() {
	return dao.top10new();
}
@Override
public Page<Product> findAll(Pageable pageable) {
	// TODO Auto-generated method stub
	return dao.findAll(pageable);
}



}
