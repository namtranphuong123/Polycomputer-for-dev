package polycomputer.service;

import java.util.List;

import polycomputer.entity.Gift;

public interface GiftService {

	void deleteById(Integer id);

	Gift update(Gift gift);

	Gift create(Gift gift);

	Gift findById(Integer id);

	List<Gift> findAll();

}
