package polycomputer.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import polycomputer.dao.AccountDao;
import polycomputer.entity.Account;
import polycomputer.entity.Order;
import polycomputer.entity.OrderDetail;
import polycomputer.entity.Product;
import polycomputer.entity.Role;
import polycomputer.service.AccountService;


@Service
public class AccountSeviceImpl implements AccountService {
@Autowired
AccountDao dao;
@Autowired
@Lazy
BCryptPasswordEncoder pe;

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public void deleteById(String username) {
dao.deleteById(username);		
	}

	

	@Override
	public Optional<Account> findByIdedit(String username) {
		return dao.findById(username);
	}

	@Override
	public void save(Account entity) {
		dao.save(entity);
	}
	/*
	 * @Override public Customer findByUsername(String username) { return
	 * dao.findByUsername(username); }
	 * 
	 * @Override public List<Customer> getAdministratos() { return
	 * dao.getAdministratos(); }
	 */

	@Override
	public List<Account> getAdministratos() {
		return dao.getAdministrators();
	}

	@Override
	public Optional<Account> findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username);
	}

	@Override
	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		String  fullname = oauth2.getPrincipal().getAttribute("name");
String  email = oauth2.getPrincipal().getAttribute("email");
//System.currentTimeMillis() sinh ra mật khẩu ngẫu nhiên

String password = Long.toHexString(System.currentTimeMillis());
UserDetails user = User.withUsername(email)
.password(pe.encode(password)).roles("USER").build();





Authentication auth = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
SecurityContextHolder.getContext().setAuthentication(auth);

Account acc = new Account();
acc.setUsername(email);
acc.setFullName(fullname);
acc.setEmail(email);
acc.setCreatedAt(new Date());
acc.setPassword(password);
dao.save(acc);
	}
	

	

	
	
	


	

	

}
