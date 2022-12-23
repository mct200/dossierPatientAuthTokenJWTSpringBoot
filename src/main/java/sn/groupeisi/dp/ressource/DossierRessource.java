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

import sn.groupeisi.dp.domain.Dossier;
import sn.groupeisi.dp.service.DossierService;

@RestController

@RequestMapping("/dossier")
public class DossierRessource  {

	private final DossierService dossierService;
	@Autowired
	public DossierRessource(DossierService dossierService) {
		
		this.dossierService = dossierService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Dossier>> getAllPatient(){
		List<Dossier>dossiers=dossierService.findAllDossiers();
		return new ResponseEntity<>(dossiers,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Dossier> getPatientById(@PathVariable("id")Long id){
		Dossier dossier=dossierService.findDossierById(id);
		return new ResponseEntity<>(dossier,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Dossier> addDossier(@RequestBody Dossier dossier){
		Dossier newDossier=dossierService.addDossier(dossier);
		return new ResponseEntity<>(newDossier,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Dossier> updateDossier(@RequestBody Dossier dossier){
	Dossier updateDossier=dossierService.updateDossier(dossier);
		return new ResponseEntity<>(updateDossier,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Dossier> deletePatient(@PathVariable("id")Long id){
		dossierService.deleteDossier(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}



}
