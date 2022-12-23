package sn.groupeisi.dp.service;

import java.util.List;

import sn.groupeisi.dp.domain.Role;
import sn.groupeisi.dp.domain.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User>getUsers();
	

}
