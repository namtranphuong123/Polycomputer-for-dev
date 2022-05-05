package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.Status;
import polycomputer.service.StatusService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/statuses")
public class StatusRestController {
	@Autowired
	StatusService statusService;
	
	@GetMapping()
	public List<Status> getAll() {
		return statusService.findAll();
	}
	
}
