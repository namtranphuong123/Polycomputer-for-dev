package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.ChipDoHoaDao;
import polycomputer.dao.ColorDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.ChipDoHoa;
import polycomputer.entity.Color;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.ChipDoHoaService;
import polycomputer.service.ColorService;
import polycomputer.service.AccountService;


@Service
public class ColorServiceImpl implements ColorService {
@Autowired
ColorDao dao;
@Override
public List<Color> findAll() {
	
	return dao.findAll();
}
@Override
public Color findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public Color create(Color color) {
	return dao.save(color);
}
@Override
public Color update(Color color) {
	return dao.save(color);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
