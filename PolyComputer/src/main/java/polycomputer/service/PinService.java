package polycomputer.service;

import java.util.List;

import polycomputer.entity.Pin;

public interface PinService {

	void deleteById(Integer id);

	Pin update(Pin Pin);

	Pin create(Pin Pin);

	Pin findById(Integer id);

	List<Pin> findAll();

}
