package sn.groupeisi.dp.controller;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import sn.groupeisi.dp.domain.Role;
import sn.groupeisi.dp.domain.User;
import sn.groupeisi.dp.ressource.UserRoleRessource;
import sn.groupeisi.dp.service.UserService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	@Value("${jwtSecret}")
	private String jwtSecret;
	@GetMapping("/users")
	public ResponseEntity<List<User>>getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
			
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toString());
				
		return ResponseEntity.created(uri).body(userService.saveUser(user));
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Role> saveUser(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles").toString());
				
		return ResponseEntity.created(uri).body(userService.saveRole(role));
	}
	@PostMapping("roles/adduser")
	public ResponseEntity<?> addRoleToUser(@RequestBody UserRoleRessource userRoleRessource){
		userService.addRoleToUser(userRoleRessource.getUsername(), userRoleRessource.getRoleName()); 
		return ResponseEntity.ok().build();
	}
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")) {
			try {
				String refreshToken =authorizationHeader.substring("Bearer".length());
				Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
				JWTVerifier jwtVerifier = JWT.require(algorithm).build();
				
				DecodedJWT decodedJWT =jwtVerifier.verify(refreshToken);
				String username = decodedJWT.getSubject();
				User user = userService.getUser(username);
				String accessToken = JWT.create().withSubject(username)
						.withExpiresAt(new Date( System.currentTimeMillis()+ 10 *60*1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles",user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
						.sign(algorithm);
				Map<String, String> tokens = new HashMap<String, String>();	
				tokens.put("access_token", accessToken);
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
			}catch(Exception e) {
				response.setHeader("error", e.getMessage());
				response.setStatus(HttpStatus.FORBIDDEN.value());
				Map<String, String> error = new HashMap<String, String>();	
				error.put("error",e.getMessage());
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		}else {
			throw new RuntimeException("Refresh token not found");
			
		}
	}
}
