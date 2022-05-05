package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.ChipDoHoaDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.ChipDoHoa;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.ChipDoHoaService;
import polycomputer.service.AccountService;


@Service
public class ChipDoHoaServiceImpl implements ChipDoHoaService {
@Autowired
ChipDoHoaDao dao;
@Override
public List<ChipDoHoa> findAll() {
	
	return dao.findAll();
}
@Override
public ChipDoHoa findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public ChipDoHoa create(ChipDoHoa chipDoHoa) {
	return dao.save(chipDoHoa);
}
@Override
public ChipDoHoa update(ChipDoHoa chipDoHoa) {
	return dao.save(chipDoHoa);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
