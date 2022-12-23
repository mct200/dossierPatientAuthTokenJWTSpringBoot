package sn.groupeisi.dp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Prescripteur;
import sn.groupeisi.dp.dossier.dao.PrescripteurRepository;
import sn.groupeisi.dp.exception.UserNotFoundException;

@Service
public class PrescripteurService {
	private final PrescripteurRepository prescripteurRepository ;

	@Autowired
public PrescripteurService(PrescripteurRepository prescripteurRepository) {
	this.prescripteurRepository=prescripteurRepository;
	}

	public Prescripteur addPrescripteur(Prescripteur prescripteur) {
		
		return prescripteurRepository.save(prescripteur);
	}
	public List<Prescripteur>findAllPrescripteurs(){
		return prescripteurRepository.findAll();
	}
	public Prescripteur updatePrescripteur(Prescripteur prescripteur) {
		return prescripteurRepository.save(prescripteur);
	}
	public Prescripteur findPrescripteurById(Long id) {
		return prescripteurRepository.findPrescripteurById(id).orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
	}

	public void deletePrescripteur(Long id) {
		
		prescripteurRepository.deletePrescripteurById(id);
	}
}
