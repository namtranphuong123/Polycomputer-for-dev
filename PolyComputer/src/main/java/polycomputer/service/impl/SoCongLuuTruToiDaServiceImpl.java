package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.SoCongLuuTruToiDaDao;
import polycomputer.entity.SoCongLuuTruToiDa;
import polycomputer.service.SoCongLuuTruToiDaService;


@Service
public class SoCongLuuTruToiDaServiceImpl implements SoCongLuuTruToiDaService {
@Autowired
SoCongLuuTruToiDaDao dao;
@Override
public List<SoCongLuuTruToiDa> findAll() {
	
	return dao.findAll();
}
@Override
public SoCongLuuTruToiDa findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public SoCongLuuTruToiDa create(SoCongLuuTruToiDa soCongLuuTruToiDa) {
	return dao.save(soCongLuuTruToiDa);
}
@Override
public SoCongLuuTruToiDa update(SoCongLuuTruToiDa soCongLuuTruToiDa) {
	return dao.save(soCongLuuTruToiDa);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
