package sn.groupeisi.dp.dossier.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsername(String username);
	}