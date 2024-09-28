package com.tournament.performance.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tournament.performance.model.PerformanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class PerformanceServiceImpl implements PerformanceServiceInterface{
    private RestTemplate restTemplate;

    @Autowired
    PerformanceServiceImpl(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }
    @Autowired
     private KafkaTemplate<Object, String> kafkaTemplate;

    @Override
    public List<PerformanceDTO> getAllData() throws JsonProcessingException {
        ResponseEntity<List<PerformanceDTO>> result =restTemplate.exchange("http://localhost:3232/ipldata", HttpMethod.GET, null, new ParameterizedTypeReference<List<PerformanceDTO>>() { });
        List<PerformanceDTO> resultList = result.getBody();
        ObjectMapper objMappr=new ObjectMapper();
        objMappr.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String bookmarkData=objMappr.writeValueAsString(resultList);
        if(!resultList.isEmpty()) {
            return resultList;
        } else{
            return null;
        }
    }

    public List<PerformanceDTO> getDataByPlayer(String playerName) throws JsonProcessingException {
        ResponseEntity<List<PerformanceDTO>> result =restTemplate.exchange("http://localhost:3232/ipldata?Player="+playerName, HttpMethod.GET, null, new ParameterizedTypeReference<List<PerformanceDTO>>() { });
        List<PerformanceDTO> resultList = result.getBody();
        ObjectMapper objMappr=new ObjectMapper();
        objMappr.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        if(!resultList.isEmpty()) {
            return resultList;
        } else{
            return null;
        }
    }
    public List<PerformanceDTO> getDataByTeam(String TeamName) throws JsonProcessingException {
        ResponseEntity<List<PerformanceDTO>> result =restTemplate.exchange("http://localhost:3232/ipldata?Team="+TeamName, HttpMethod.GET, null, new ParameterizedTypeReference<List<PerformanceDTO>>() { });
        List<PerformanceDTO> resultList = result.getBody();
        ObjectMapper objMappr=new ObjectMapper();
        objMappr.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        if(!resultList.isEmpty()) {
            return resultList;
        } else{
            return null;
        }
    }
    public List<PerformanceDTO> getDataByTournament(String TournamentName) throws JsonProcessingException {
        ResponseEntity<List<PerformanceDTO>> result =restTemplate.exchange("http://localhost:3232/ipldata?Tournament="+TournamentName, HttpMethod.GET, null, new ParameterizedTypeReference<List<PerformanceDTO>>() { });
        List<PerformanceDTO> resultList = result.getBody();
        ObjectMapper objMappr=new ObjectMapper();
        objMappr.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        if(!resultList.isEmpty()) {
            return resultList;
        } else{
            return null;
        }
    }

    @Override
    public String savePlayerData(PerformanceDTO data) throws JsonProcessingException {
        return null;
    }

}
