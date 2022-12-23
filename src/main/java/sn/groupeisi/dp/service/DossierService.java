package sn.groupeisi.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Dossier;

import sn.groupeisi.dp.dossier.dao.DossierRepository;

import sn.groupeisi.dp.exception.UserNotFoundException;
@Service
public class DossierService {
	private final DossierRepository dossierRepository ;
	
	@Autowired
public DossierService(DossierRepository dossierRepository) {
	this.dossierRepository = dossierRepository;
}

	public List<Dossier> findAllDossiers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dossier addDossier(Dossier dossier) {
		
		return dossierRepository.save(dossier);
	}


	public Dossier findDossierById(Long id) {
		return dossierRepository.findDossierById(id).orElseThrow(()->new UserNotFoundException("Patient by id" + id+ "was not found"));
	}

	public void deleteDossier(Long id) {
		dossierRepository.deleteDossierById(id);

		
	}

	public Dossier updateDossier(Dossier dossier) {
		return dossierRepository.save(dossier);	}

	
	











}
