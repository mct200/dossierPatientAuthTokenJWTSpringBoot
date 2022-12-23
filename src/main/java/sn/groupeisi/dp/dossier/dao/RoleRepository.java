package sn.groupeisi.dp.dossier.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.groupeisi.dp.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String roleName);
}
