package com.tournament.authentication.controller;

import com.tournament.authentication.model.Authentication;
import com.tournament.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
//    @PostMapping("/register")
//    public ResponseEntity<?> addUser(@RequestBody Authentication user) {
//        Authentication uu = authenticationService.addUser(user);
//        return new ResponseEntity<Authentication>(uu, HttpStatus.OK);
//    }
    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody Authentication user) {
        return new ResponseEntity<>(authenticationService.Login(user), HttpStatus.OK);
    }

}
