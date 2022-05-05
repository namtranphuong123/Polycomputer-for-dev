package polycomputer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import polycomputer.entity.Account;
import polycomputer.entity.Product;

public interface AccountService {

	List<Account> getAdministratos();

	

	void save(Account entity);

	Optional<Account> findByIdedit(String username);

	void deleteById(String username);

	Account update(Account account);

	Account create(Account account);

	Account findById(String username);

	List<Account> findAll();

	void loginFromOAuth2(OAuth2AuthenticationToken oauth2);



	Optional<Account> findByUsername(String username);



	

}
