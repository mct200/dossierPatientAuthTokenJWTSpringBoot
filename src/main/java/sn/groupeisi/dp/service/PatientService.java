package sn.groupeisi.dp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.groupeisi.dp.domain.Patient;
import sn.groupeisi.dp.dossier.dao.PatientRepository;
import sn.groupeisi.dp.exception.UserNotFoundException;
@Service
public class PatientService {
	private final PatientRepository patientRepository ;
	
		@Autowired
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	

	public Patient addPatient(Patient patient) {
		
		return patientRepository.save(patient);
	}
	
	public List<Patient>findAllPatients(){
		return patientRepository.findAll();
	}
	public Patient updatePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	

	public Patient findPatientById(Long id) {
		
		return patientRepository.findPatientById(id).orElseThrow(()->new UserNotFoundException("Patient by id" + id+ "was not found"));
	}



	public void deletePatient(Long id) {
		
		patientRepository.deletePatientById(id);
	}
}
