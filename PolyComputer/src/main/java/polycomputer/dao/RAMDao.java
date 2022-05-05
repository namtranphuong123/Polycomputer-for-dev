package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Product;
import polycomputer.entity.RAM;

@Repository
public interface RAMDao extends JpaRepository<RAM, Integer>{
	List<RAM> findByRamNameContaining(String name);

}
