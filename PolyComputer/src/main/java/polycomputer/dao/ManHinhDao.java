package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.LuuTru;
import polycomputer.entity.ManHinh;

@Repository
public interface ManHinhDao extends JpaRepository<ManHinh, Integer>{
	List<ManHinh> findByManHinhNameContaining(String name);

}
