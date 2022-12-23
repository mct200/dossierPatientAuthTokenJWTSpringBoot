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

import sn.groupeisi.dp.domain.Secretaire;
import sn.groupeisi.dp.service.SecretaireService;

@RestController

@RequestMapping("/secretaire")
public class SecretaireRessource {
	private final SecretaireService secretaireService;
	@Autowired
	public SecretaireRessource( SecretaireService secretaireService) {
		this.secretaireService=secretaireService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Secretaire>> getAllSecretaire(){
		List<Secretaire>secretaires=secretaireService.findAllSecretaires();
		return new ResponseEntity<>(secretaires,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Secretaire> getSecretaireById(@PathVariable("id")Long id){
		Secretaire secretaire=secretaireService.findSecretaireById(id);
		return new ResponseEntity<>(secretaire,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Secretaire> addSecretaire(@RequestBody Secretaire secretaire){
		Secretaire newSecretaire=secretaireService.addSecretaire(secretaire);
		return new ResponseEntity<>(newSecretaire,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Secretaire> updateSecretaire(@RequestBody Secretaire secretaire){
		Secretaire updateSecretaire=secretaireService.updateSecretaire(secretaire);
		return new ResponseEntity<>(updateSecretaire,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Secretaire> deleteSecretaire(@PathVariable("id")Long id){
		secretaireService.deleteSecretaire(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}


}
