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

import sn.groupeisi.dp.domain.Patient;
import sn.groupeisi.dp.service.PatientService;

@RestController

@RequestMapping("/patient")
public class PatientRessource {
	private final PatientService patientService;
	@Autowired
	public PatientRessource(PatientService patientService) {
		
		this.patientService = patientService;
	}
	@GetMapping("/list")
	public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient>patients=patientService.findAllPatients();
		return new ResponseEntity<>(patients,HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id")Long id){
		Patient patient=patientService.findPatientById(id);
		return new ResponseEntity<>(patient,HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
		Patient newPatient=patientService.addPatient(patient);
		return new ResponseEntity<>(newPatient,HttpStatus.CREATED);

	}
	@PutMapping("/update")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
		Patient updatePatient=patientService.updatePatient(patient);
		return new ResponseEntity<>(updatePatient,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("id")Long id){
		patientService.deletePatient(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
