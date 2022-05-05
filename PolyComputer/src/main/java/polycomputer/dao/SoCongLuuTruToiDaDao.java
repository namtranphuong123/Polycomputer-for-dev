package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.RAM;
import polycomputer.entity.SoCongLuuTruToiDa;

@Repository
public interface SoCongLuuTruToiDaDao extends JpaRepository<SoCongLuuTruToiDa, Integer>{
	List<SoCongLuuTruToiDa> findBySoCongLuuTruToiDaNameContaining(String name);

}
