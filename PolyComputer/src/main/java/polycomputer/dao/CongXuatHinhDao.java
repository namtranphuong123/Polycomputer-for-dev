package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Color;
import polycomputer.entity.CongXuatHinh;

@Repository
public interface CongXuatHinhDao extends JpaRepository<CongXuatHinh, Integer>{
	List<CongXuatHinh> findByCongXuatHinhNameContaining(String name);

}
