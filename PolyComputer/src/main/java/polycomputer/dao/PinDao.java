package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.PhuKienDiKem;
import polycomputer.entity.Pin;

@Repository
public interface PinDao extends JpaRepository<Pin, Integer>{
	List<Pin> findByPinNameContaining(String name);

}
