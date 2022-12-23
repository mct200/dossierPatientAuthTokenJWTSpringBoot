package sn.groupeisi.dp.dossier.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Secretaire;
@Repository
public interface SecretaireRepository extends JpaRepository<Secretaire,Long> {

	Optional<Secretaire> findSecretaireById(Long id);

	void deleteSecretaireById(Long id);

}
