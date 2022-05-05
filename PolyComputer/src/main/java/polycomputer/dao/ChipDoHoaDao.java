package polycomputer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.ChipDoHoa;

@Repository

public interface ChipDoHoaDao extends JpaRepository<ChipDoHoa,Integer>{
	List<ChipDoHoa> findByChipDoHoaNameContaining(String name);
}
