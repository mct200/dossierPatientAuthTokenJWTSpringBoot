package sn.groupeisi.dp.dossier.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import sn.groupeisi.dp.domain.Prescripteur;
@Repository
public interface PrescripteurRepository extends JpaRepository<Prescripteur,Long> {

	Optional<Prescripteur> findPrescripteurById(Long id);

	void deletePrescripteurById(Long id);


}
