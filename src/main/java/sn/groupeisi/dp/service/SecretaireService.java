package sn.groupeisi.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Secretaire;
import sn.groupeisi.dp.dossier.dao.SecretaireRepository;
import sn.groupeisi.dp.exception.UserNotFoundException;
@Service
public class SecretaireService {
	private final SecretaireRepository secretaireRepository ;
	@Autowired
	public SecretaireService(SecretaireRepository secretaireRepository) {
		this.secretaireRepository = secretaireRepository;
	}
	

	public Secretaire addSecretaire(Secretaire secretaire) {
		
		return secretaireRepository.save(secretaire);
	}
	
	public List<Secretaire>findAllSecretaires(){
		return secretaireRepository.findAll();
	}
	public Secretaire updateSecretaire(Secretaire secretaire) {
		return secretaireRepository.save(secretaire);
	}
	

	public Secretaire findSecretaireById(Long id) {
		
		return secretaireRepository.findSecretaireById(id).orElseThrow(()->new UserNotFoundException("Secretaire by id" + id+ "was not found"));
	}



	public void deleteSecretaire(Long id) {
		
		secretaireRepository.deleteSecretaireById(id);
	}
	

}
