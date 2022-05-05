package polycomputer.service;

import java.util.List;

import polycomputer.entity.Role;

public interface RoleService {

	void deleteById(Integer id);

	Role update(Role role);

	Role create(Role role);

	Role findById(Integer id);

	List<Role> findAll();

}
