package polycomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polycomputer.entity.LeaderShip;

@Repository
public interface LeadershipDao extends JpaRepository<LeaderShip, Integer>{

}
