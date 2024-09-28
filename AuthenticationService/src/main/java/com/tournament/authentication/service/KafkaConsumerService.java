package com.tournament.authentication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.authentication.model.Authentication;
import com.tournament.authentication.model.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class KafkaConsumerService {
	@Autowired
	public AuthenticationServiceInterface authService;
	  
    @KafkaListener(topics="UserAuth",groupId="grp1")
    public void getMessageFromkafka(String msg) throws JsonMappingException, JsonProcessingException {
    	
        System.out.println("******************* in consumer @KafkaListener************"+msg);
        ObjectMapper objectMapper=new ObjectMapper();
        UserDTO userObj=objectMapper.readValue(msg, new TypeReference<UserDTO>(){});

        if(userObj.getEmailId() != null) {          
        	authService.saveAuthUser(userObj);
        	 System.out.println("******savedUser**********");
//        	if(savedUser.getEmail() != null) {
//        		Map<String,String> authTokan = authService.Login(savedUser);
//        	}
        }
    }
}
