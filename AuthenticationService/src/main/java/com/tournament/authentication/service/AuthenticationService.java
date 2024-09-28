package com.tournament.authentication.service;

import com.tournament.authentication.model.Authentication;
import com.tournament.authentication.model.UserDTO;
import com.tournament.authentication.repository.AuthenticationRepositoryInterface;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class AuthenticationService implements AuthenticationServiceInterface{
    @Autowired
    private AuthenticationRepositoryInterface authRepository;
    
    
    
    public Authentication saveAuthUser(UserDTO user) {
    	Authentication authuser = new Authentication();
    	authuser.setEmail(user.getEmailId());
    	authuser.setPassword(user.getPassword());
    	
    	System.out.println("**************in saveAuthUser******************");
    	System.out.println(user);
    	
    	return authRepository.save(authuser);   	
    }
    
    public Map<String,String> Login(Authentication u){
        Map<String, String> token = new HashMap<String, String>();
        Authentication u1 = authRepository.findByEmailAndPassword(u.getEmail(), u.getPassword());
        if (u1 != null) {
            token = getJwtToken(u);
        }
        return token;
    }
    public Map<String,String> getJwtToken(Authentication u)
    {
        String jwtToken = Jwts.builder().setSubject(u.getEmail())
                .setIssuedAt(new Date(0))
                .signWith(SignatureAlgorithm.HS256, "secret").compact();

        Map<String, String> token = new HashMap<String, String>();
        token.put("token", jwtToken);
        return token;
    }
    

}
