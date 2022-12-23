package sn.groupeisi.dp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Traitant;
import sn.groupeisi.dp.dossier.dao.TraitantRepository;
import sn.groupeisi.dp.exception.UserNotFoundException;
@Service
public class TraitantService {
	private final TraitantRepository traitantRepository ;
	@Autowired
	public TraitantService(TraitantRepository traitantRepository) {
		this.traitantRepository = traitantRepository;
	}
	

	public Traitant addTraitant(Traitant traitant) {
		
		return traitantRepository.save(traitant);
	}
	
	public List<Traitant>findAllTraitants(){
		return traitantRepository.findAll();
	}
	public Traitant updateTraitant(Traitant traitant) {
		return traitantRepository.save(traitant);
	}
	

	public Traitant findTraitantById(Long id) {
		
		return traitantRepository.findTraitantById(id).orElseThrow(()->new UserNotFoundException("Traitant by id" + id+ "was not found"));
	}



	public void deleteTraitant(Long id) {
		
		traitantRepository.deleteTraitantById(id);
	}
	


}
