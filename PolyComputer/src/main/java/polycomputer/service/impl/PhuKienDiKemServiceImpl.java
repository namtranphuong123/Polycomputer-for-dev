package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.PhuKienDiKemDao;
import polycomputer.entity.PhuKienDiKem;
import polycomputer.service.PhuKienDiKemService;


@Service
public class PhuKienDiKemServiceImpl implements PhuKienDiKemService {
@Autowired
PhuKienDiKemDao dao;
@Override
public List<PhuKienDiKem> findAll() {
	
	return dao.findAll();
}
@Override
public PhuKienDiKem findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public PhuKienDiKem create(PhuKienDiKem PhuKienDiKem) {
	return dao.save(PhuKienDiKem);
}
@Override
public PhuKienDiKem update(PhuKienDiKem PhuKienDiKem) {
	return dao.save(PhuKienDiKem);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
