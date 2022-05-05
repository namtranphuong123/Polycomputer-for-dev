package polycomputer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.AccountDao;
import polycomputer.dao.AuthorityDao;
import polycomputer.entity.Account;
import polycomputer.entity.Authority;
import polycomputer.service.AuthorityService;



@Service
public class AuthorityServiceImpl  implements AuthorityService{
	@Autowired
	AuthorityDao authorityDao;
	@Autowired
	AccountDao accountDao;

	
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return authorityDao.findAll();
	}

	
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> accounts = accountDao.getAdministrators();
		return authorityDao.authoritiesOf(accounts);
	}

	
	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return authorityDao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		authorityDao.deleteById(id);
	}

	
	@Override
	public void save(Authority au) {
		// TODO Auto-generated method stub
		authorityDao.save(au);
	}


	

}
