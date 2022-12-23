package sn.groupeisi.dp.dossier.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Traitant;
@Repository
public interface TraitantRepository extends JpaRepository<Traitant,Long>  {

	Optional<Traitant> findTraitantById(Long id);

	void deleteTraitantById(Long id);

}
