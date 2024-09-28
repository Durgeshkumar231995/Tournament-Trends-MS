package com.tournament.userprofile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tournament.userprofile.model.userProfile;

public interface userProfileServiceInterface {
    public userProfile getUserById(int id);
    public void deleteuserById(int id);
    public userProfile updateUser(int id,userProfile user);
    public userProfile saveUser(userProfile user) throws JsonProcessingException;
}
