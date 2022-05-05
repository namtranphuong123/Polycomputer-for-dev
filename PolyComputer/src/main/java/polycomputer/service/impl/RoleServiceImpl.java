package polycomputer.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.RoleDao;
import polycomputer.entity.Role;
import polycomputer.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
@Autowired
RoleDao dao;
@Override
public List<Role> findAll() {
	
	return dao.findAll();
}
@Override
public Role findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Role create(Role role) {
	return dao.save(role);
}
@Override
public Role update(Role role) {
	return dao.save(role);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
