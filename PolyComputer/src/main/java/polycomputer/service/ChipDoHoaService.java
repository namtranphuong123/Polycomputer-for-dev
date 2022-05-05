package polycomputer.service;

import java.util.List;

import polycomputer.entity.ChipDoHoa;

public interface ChipDoHoaService {

	void deleteById(Integer id);

	ChipDoHoa update(ChipDoHoa chipDoHoa);

	ChipDoHoa create(ChipDoHoa chipDoHoa);

	ChipDoHoa findById(Integer id);

	List<ChipDoHoa> findAll();

}
