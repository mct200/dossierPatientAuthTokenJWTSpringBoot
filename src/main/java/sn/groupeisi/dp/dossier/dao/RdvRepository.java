package sn.groupeisi.dp.dossier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Rdv;
@Repository
public interface RdvRepository extends JpaRepository<Rdv,Long> {

	boolean deleteRdvById(int id_appointment);

}
