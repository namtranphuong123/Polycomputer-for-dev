package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.ManHinh;
import polycomputer.entity.PhuKienDiKem;

@Repository
public interface PhuKienDiKemDao extends JpaRepository<PhuKienDiKem, Integer>{
	List<PhuKienDiKem> findByPhuKienDiKemNameContaining(String name);

}
