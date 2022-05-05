package polycomputer.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.PinDao;
import polycomputer.entity.Pin;
import polycomputer.service.PinService;


@Service
public class PinServiceImpl implements PinService {
@Autowired
PinDao dao;
@Override
public List<Pin> findAll() {
	
	return dao.findAll();
}
@Override
public Pin findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Pin create(Pin Pin) {
	return dao.save(Pin);
}
@Override
public Pin update(Pin Pin) {
	return dao.save(Pin);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
