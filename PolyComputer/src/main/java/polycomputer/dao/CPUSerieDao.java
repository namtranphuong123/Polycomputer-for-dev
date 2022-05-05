package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.CPU;
import polycomputer.entity.CPUSerie;

@Repository
public interface CPUSerieDao extends JpaRepository<CPUSerie, Integer>{
	List<CPUSerie> findByCpuSerieNameContaining(String name);

}
