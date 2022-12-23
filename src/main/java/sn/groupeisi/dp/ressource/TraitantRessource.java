package sn.groupeisi.dp.ressource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.groupeisi.dp.domain.Traitant;
import sn.groupeisi.dp.service.TraitantService;


@RestController

@RequestMapping("/traitant")
public class TraitantRessource {
	private final TraitantService traitantService;
	@Autowired
	public TraitantRessource( TraitantService traitantService) {
		this.traitantService=traitantService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Traitant>> getAllTraitant(){
		List<Traitant>secretaires=traitantService.findAllTraitants();
		return new ResponseEntity<>(secretaires,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Traitant> getTraitantById(@PathVariable("id")Long id){
		Traitant traitant=traitantService.findTraitantById(id);
		return new ResponseEntity<>(traitant,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Traitant> addTraitant(@RequestBody Traitant traitant){
		Traitant newTraitant=traitantService.addTraitant(traitant);
		return new ResponseEntity<>(newTraitant,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Traitant> updateTraitant(@RequestBody Traitant traitant){
		Traitant updateTraitant=traitantService.updateTraitant(traitant);
		return new ResponseEntity<>(updateTraitant,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Traitant> deleteTraitant(@PathVariable("id")Long id){
		traitantService.deleteTraitant(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}



}
