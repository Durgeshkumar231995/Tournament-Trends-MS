package com.tournament.authentication.service;

import com.tournament.authentication.model.Authentication;
import com.tournament.authentication.model.UserDTO;

import java.util.Map;

public interface AuthenticationServiceInterface {
    public Map<String,String> Login(Authentication user);
    public Map<String,String> getJwtToken(Authentication user);
    public Authentication saveAuthUser(UserDTO user);
    
}
