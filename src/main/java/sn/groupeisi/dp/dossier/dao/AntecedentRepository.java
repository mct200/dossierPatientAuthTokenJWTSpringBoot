package sn.groupeisi.dp.dossier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Antecedent;
@Repository
public interface AntecedentRepository extends JpaRepository<Antecedent,Long> {

}
