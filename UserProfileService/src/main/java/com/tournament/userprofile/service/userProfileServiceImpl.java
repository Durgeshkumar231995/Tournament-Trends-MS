package com.tournament.userprofile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tournament.userprofile.model.userProfile;
import com.tournament.userprofile.repository.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class userProfileServiceImpl implements userProfileServiceInterface{
    
    @Autowired
    private UserProfileRepo userRepo;

   public userProfile getUserById(int id) {
       Optional<userProfile> userById=userRepo.findById(id);
       return userById.get();
    }

    public void deleteuserById(int id) {
        userRepo.deleteById(id);
    }

   public userProfile updateUser(int id, userProfile user) {
       Optional<userProfile> existingRecord=userRepo.findById(id);
       userProfile thisUser=existingRecord.get();
       thisUser.setUserId(user.getUserId());
       thisUser.setPassword(user.getPassword());
       thisUser.setFirstName(user.getFirstName());
       thisUser.setUserId(user.getUserId());
       thisUser.setUsername(user.getUsername());
       thisUser.setPassword(user.getPassword());
       thisUser.setFirstName(user.getFirstName());
       thisUser.setLastName(user.getLastName());
       thisUser.setMobileNo(user.getMobileNo());
       thisUser.setEmailId(user.getEmailId());
       thisUser.setAge(user.getAge());
       return userRepo.save(thisUser);
    }
    public userProfile saveUser(userProfile user) throws JsonProcessingException {
        if(user.getPassword() != null && (user.getPassword().equals(user.getConfirmPassword()))){
            userProfile userObj = new userProfile();
            userObj.setUserId(user.getUserId());
            userObj.setUsername(user.getUsername());
            userObj.setPassword(user.getPassword());
            userObj.setFirstName(user.getFirstName());
            userObj.setLastName(user.getLastName());
            userObj.setMobileNo(user.getMobileNo());
            userObj.setEmailId(user.getEmailId());
            userObj.setAge(user.getAge());
            return userRepo.save(userObj);
        }else {
            return null;
        }
   }
}
