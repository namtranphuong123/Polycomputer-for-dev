package polycomputer.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import polycomputer.entity.Account;
import polycomputer.entity.Authority;
import polycomputer.entity.Role;
import polycomputer.service.AccountService;
import polycomputer.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder pe;
	
	@GetMapping("{id}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findById(username);
	}

	@GetMapping()
	public List<Account> getAccount(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return accountService.getAdministratos();
		}
		return accountService.findAll();

	}

	@PostMapping
	public Account create(@RequestBody Account account) {
       
		
		account.setPassword(pe.encode(account.getPassword()));
		
	
		
	
		return accountService.create(account);
	}

	@PutMapping("{username}")
	public Account update(@PathVariable("username") String username, @RequestBody Account account) {
		return accountService.update(account);
	}

			
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accountService.deleteById(username);
	}
	
	
	
	@GetMapping("/account-session")
	public ResponseEntity<Account> getAccountInSession(Authentication authentication){
		Account accountDTO = accountService.findById(authentication.getName());
		
		return new ResponseEntity<Account>(accountDTO, HttpStatus.OK);
}
}
