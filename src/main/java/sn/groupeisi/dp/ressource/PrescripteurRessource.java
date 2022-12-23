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

import sn.groupeisi.dp.domain.Prescripteur;
import sn.groupeisi.dp.service.PrescripteurService;
@RestController
@RequestMapping("/prescripteur")
public class PrescripteurRessource {
	private final PrescripteurService prescripteurService;
	@Autowired
	public PrescripteurRessource( PrescripteurService prescripteurService) {
		this.prescripteurService=prescripteurService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Prescripteur>> getAllPrescripteur(){
		List<Prescripteur>prescripteurs=prescripteurService.findAllPrescripteurs();
		return new ResponseEntity<>(prescripteurs,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Prescripteur> getPrescripteurById(@PathVariable("id")Long id){
		Prescripteur prescripteur=prescripteurService.findPrescripteurById(id);
		return new ResponseEntity<>(prescripteur,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Prescripteur> addPrescripteur(@RequestBody Prescripteur prescripteur){
		Prescripteur newPrescripteur=prescripteurService.addPrescripteur(prescripteur);
		return new ResponseEntity<>(newPrescripteur,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Prescripteur> updatePrescripteur(@RequestBody Prescripteur prescripteur){
		Prescripteur updatePrescripteur=prescripteurService.updatePrescripteur(prescripteur);
		return new ResponseEntity<>(updatePrescripteur,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Prescripteur> deletePrescripteur(@PathVariable("id")Long id){
		prescripteurService.deletePrescripteur(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
