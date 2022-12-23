package sn.groupeisi.dp.dossier.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{
	
	 Optional<Patient> findPatientById(Long id);

	void deletePatientById(Long id);
	
}
