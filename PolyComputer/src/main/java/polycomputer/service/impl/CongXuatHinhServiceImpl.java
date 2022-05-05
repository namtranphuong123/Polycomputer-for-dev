package polycomputer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import polycomputer.dao.BanPhimDao;
import polycomputer.dao.CongKetNoiDao;
import polycomputer.dao.CongXuatHinhDao;
import polycomputer.dao.AccountDao;
import polycomputer.entity.BanPhim;
import polycomputer.entity.CongKetNoi;
import polycomputer.entity.CongXuatHinh;
import polycomputer.entity.Account;
import polycomputer.service.BanPhimService;
import polycomputer.service.CongKetNoiService;
import polycomputer.service.CongXuatHinhService;
import polycomputer.service.AccountService;


@Service
public class CongXuatHinhServiceImpl implements CongXuatHinhService {
@Autowired
CongXuatHinhDao dao;
@Override
public List<CongXuatHinh> findAll() {
	
	return dao.findAll();
}
@Override
public CongXuatHinh findById(Integer id) {
	return dao.findById(id).get();
}
@Override
public CongXuatHinh create(CongXuatHinh congXuatCauHinh) {
	return dao.save(congXuatCauHinh);
}
@Override
public CongXuatHinh update(CongXuatHinh congXuatCauHinh) {
	return dao.save(congXuatCauHinh);


}
@Override
public void deleteById(Integer id) {
	 dao.deleteById(id);		
}



}
