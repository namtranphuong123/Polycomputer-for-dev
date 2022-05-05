package polycomputer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import polycomputer.entity.Account;
import polycomputer.entity.Star;

public interface StarService {

	List<Star> findAll();


}
