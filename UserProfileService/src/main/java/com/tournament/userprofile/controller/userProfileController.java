package com.tournament.userprofile.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.userprofile.model.userProfile;
import com.tournament.userprofile.service.KafkaProducerService;
import com.tournament.userprofile.service.userProfileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Optional;

@RestController
@RequestMapping("api/v2")
public class userProfileController {

    @Autowired
    private userProfileServiceInterface userService;
    @Autowired
    private KafkaProducerService kafkaService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> saveUser(@RequestBody userProfile user) throws JsonProcessingException {
        userProfile savedUser = userService.saveUser(user);
        if(savedUser!= null){
            kafkaService.sendDataToAuthenticationService(savedUser);
            return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Password Mismatch!",HttpStatus.OK);
        }
    }
    @PutMapping("updateProfile/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody userProfile user){
        return new ResponseEntity<>(userService.updateUser(id, user),HttpStatus.OK);
    }
    @GetMapping("/getUserProfile/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        userProfile user3=userService.getUserById(id);
        return new ResponseEntity<>(user3,HttpStatus.OK);
    }
    @DeleteMapping("deleteUserAccount/{id}")
    public String deleteByIdUser(@PathVariable int id){
        userService.deleteuserById(id);
        return "Deleted";
    }

}
