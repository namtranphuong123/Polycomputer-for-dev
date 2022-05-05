package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.StatusDao;
import polycomputer.entity.Status;
import polycomputer.service.StatusService;


@Service
public class StatusServiceImpl implements StatusService {
@Autowired
StatusDao dao;
@Override
public List<Status> findAll() {
	
	return dao.findAll();
}
@Override
public Status findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Status create(Status status) {
	return dao.save(status);
}
@Override
public Status update(Status status) {
	return dao.save(status);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
