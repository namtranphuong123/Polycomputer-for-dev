package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.RAMDao;
import polycomputer.entity.RAM;
import polycomputer.service.RAMService;


@Service
public class RAMServiceImpl implements RAMService {
@Autowired
RAMDao dao;
@Override
public List<RAM> findAll() {
	
	return dao.findAll();
}
@Override
public RAM findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public RAM create(RAM ram) {
	return dao.save(ram);
}
@Override
public RAM update(RAM ram) {
	return dao.save(ram);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
