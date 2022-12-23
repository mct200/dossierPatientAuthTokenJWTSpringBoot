package sn.groupeisi.dp.dossier.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Dossier;
@Repository
public interface DossierRepository extends JpaRepository<Dossier,Long> {

	Optional <Dossier> findDossierById(Long id);

	void deleteDossierById(Long id);

}
