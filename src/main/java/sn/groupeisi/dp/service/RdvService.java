package sn.groupeisi.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Rdv;
import sn.groupeisi.dp.dossier.dao.RdvRepository;
@Service
public class RdvService {

	private final RdvRepository rdvRepository ;
	
	@Autowired
public RdvService(RdvRepository rdvRepository) {
	this.rdvRepository = rdvRepository;
}


public Rdv addPatient(Rdv  rdv) {
	
	return rdvRepository.save( rdv);
}

public List<Rdv>findAllRdvs(){
	return rdvRepository.findAll();
}
public Rdv updateRdv(Rdv  rdv) {
	return rdvRepository.save( rdv);
}



public Rdv addRdv(Rdv rdv) {
	// TODO Auto-generated method stub
	return null;
}

}
