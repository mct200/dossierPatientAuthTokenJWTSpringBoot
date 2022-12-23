package sn.groupeisi.dp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.groupeisi.dp.domain.Role;
import sn.groupeisi.dp.domain.User;
import sn.groupeisi.dp.dossier.dao.RoleRepository;
import sn.groupeisi.dp.dossier.dao.UserRepository;
import sn.groupeisi.dp.exception.UserNotFoundException;
@Transactional
@Service
public class UserServiceImpl implements UserService,UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public User getUser(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user= userRepository.findByUsername(username);
	if(user ==null) {
		throw new UserNotFoundException("User could not be found in the db");
	}
	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
	user.getRoles().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			});
	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
	}
	

}
