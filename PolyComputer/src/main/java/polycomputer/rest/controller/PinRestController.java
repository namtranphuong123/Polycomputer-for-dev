package polycomputer.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import polycomputer.entity.BanPhim;
import polycomputer.entity.Pin;
import polycomputer.service.BanPhimService;
import polycomputer.service.PinService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/pins")
public class PinRestController {
	@Autowired
	PinService pinService;
	
	@GetMapping()
	public List<Pin> getAll() {
		return pinService.findAll();
	}
	
	@GetMapping("{id}")
	public Pin getOne(@PathVariable("id") Integer id) {
		return pinService.findById(id);
	}
	
	@PostMapping()
	public Pin create(@RequestBody Pin pin) {
		return pinService.create(pin);
	}
	
	@PutMapping("{id}")
	public Pin update(@PathVariable("id") Integer id,
			@RequestBody Pin pin) {
		return pinService.update(pin);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		pinService.deleteById(id);
	}
	
//	@GetMapping("/search")
//	public List<Pin> search(ModelMap model ,
//			@RequestParam(name = "name", required = false)String name) {
//		List<Pin> list = null;
//		if(StringUtils.hasText(name)) {
//			list = pinService.findByPinNameContaining(name);
//			
//		}else {
//			list = pinService.findAll();
//			
//		}
//		return list;
//	}
}
