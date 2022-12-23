package sn.groupeisi.dp.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;



public class AuthentificationFilter extends UsernamePasswordAuthenticationFilter{
	 private final AuthenticationManager authenticationManager ;
	 	
	 private final String jwtSecret;
	public AuthentificationFilter(AuthenticationManager authenticationManager, String jwtSecret) {
		this.authenticationManager =authenticationManager;
		this.jwtSecret = jwtSecret;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
			return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User user = (User)authResult.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
		String access_token = JWT.create().withSubject(user.getUsername()).withIssuer(request.getRequestURL().toString())
				.withExpiresAt(new Date(System.currentTimeMillis()+ 10*60*1000))
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		
		String refresh_token = JWT.create().withSubject(user.getUsername()).withIssuer(request.getRequestURL().toString())
				.withExpiresAt(new Date(System.currentTimeMillis()+ 60*60*1000))
				.sign(algorithm);
		Map<String, String> tokens =new HashMap<String,String>();
		tokens.put("access_token", access_token);
		tokens.put("refresh_token", refresh_token);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		new ObjectMapper().writeValue(response.getOutputStream(),tokens);
		
	}

	

	
}


