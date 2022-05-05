package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.HeDieuHanh;
import polycomputer.entity.LuuTru;

@Repository
public interface LuuTruDao extends JpaRepository<LuuTru, Integer>{
	List<LuuTru> findByLuuTruNameContaining(String name);

}
