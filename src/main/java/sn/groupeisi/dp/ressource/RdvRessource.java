package sn.groupeisi.dp.ressource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.groupeisi.dp.domain.Rdv;
import sn.groupeisi.dp.service.RdvService;

@RestController

@RequestMapping("/rdv")
public class RdvRessource {
	private final RdvService rdvService;
	@Autowired
	public RdvRessource(RdvService rdvService) {
		
		this.rdvService = rdvService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Rdv>> getAllRdv(){
		List<Rdv>rdvs=rdvService.findAllRdvs();
		return new ResponseEntity<>(rdvs,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Rdv> addRdv(@RequestBody Rdv rdv){
		Rdv newRdv=rdvService.addRdv(rdv);
		return new ResponseEntity<>(newRdv,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Rdv> updateRdv(@RequestBody Rdv rdv){
		Rdv updateRdv=rdvService.updateRdv(rdv);
		return new ResponseEntity<>(updateRdv,HttpStatus.OK);

	}
	

}
