package polycomputer.service;

import java.util.List;

import polycomputer.entity.Status;

public interface StatusService {

	void deleteById(Integer id);

	Status update(Status status);

	Status create(Status status);

	Status findById(Integer id);

	List<Status> findAll();

}
