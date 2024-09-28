package com.tournament.userprofile.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.userprofile.model.userProfile;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<Object, String> kafkaTemplate;
    public String sendDataToAuthenticationService(userProfile user) throws JsonProcessingException {
        ObjectMapper objMappr=new ObjectMapper();
        System.out.println("******** running sendDataToAuthenticationService*******"+user.toString());
        objMappr.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String UserData=objMappr.writeValueAsString(user);
        System.out.println("***************"+UserData);
        
        kafkaTemplate.send("UserAuth", UserData);
        return "Success";
    }
}
