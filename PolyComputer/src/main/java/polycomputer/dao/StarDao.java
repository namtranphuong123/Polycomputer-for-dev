
package polycomputer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import polycomputer.entity.Star;
import polycomputer.entity.Status;

@Repository
public interface StarDao extends JpaRepository<Star, Integer>{

}