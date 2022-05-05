package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Gift;
import polycomputer.entity.HeDieuHanh;

@Repository
public interface HeDieuHanhDao extends JpaRepository<HeDieuHanh, Integer>{
	List<HeDieuHanh> findByHeDieuHanhNameContaining(String name);

}
