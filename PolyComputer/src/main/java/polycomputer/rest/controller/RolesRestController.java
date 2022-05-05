package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.Role;
import polycomputer.entity.Status;
import polycomputer.service.RoleService;
import polycomputer.service.StatusService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RolesRestController {
	@Autowired
	RoleService roleService;
	
	@GetMapping()
	public List<Role> getAll() {
		return roleService.findAll();
	}
	
}
