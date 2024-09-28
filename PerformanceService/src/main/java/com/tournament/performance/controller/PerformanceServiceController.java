package com.tournament.performance.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tournament.performance.model.PerformanceDTO;
import com.tournament.performance.service.PerformanceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v4")
public class PerformanceServiceController {
    @Autowired
    private PerformanceServiceInterface performanceServiceInterface;

    @GetMapping("ipldata")
    public ResponseEntity<?> fetchdata() throws JsonMappingException, JsonProcessingException {
        List<PerformanceDTO> ipldata = performanceServiceInterface.getAllData();
        return new ResponseEntity<>(ipldata, HttpStatus.OK);
    }
    @GetMapping("/ipldata/Player/{playerName}")
    public ResponseEntity<?> getPlayweWiseData(@PathVariable String playerName) throws JsonMappingException, JsonProcessingException{
        List<PerformanceDTO> ipldata = performanceServiceInterface.getDataByPlayer(playerName);
        return new ResponseEntity<>(ipldata, HttpStatus.OK);
    }
    @GetMapping("/ipldata/Team/{teamName}")
    public ResponseEntity<?> getTeamWiseData(@PathVariable String teamName) throws JsonMappingException, JsonProcessingException{
        List<PerformanceDTO> ipldata = performanceServiceInterface.getDataByTeam(teamName);
        return new ResponseEntity<>(ipldata, HttpStatus.OK);
    }
    @GetMapping("/ipldata/Tournament/{TournamentName}")
    public ResponseEntity<?> getTournamentWiseData(@PathVariable String TournamentName) throws JsonMappingException, JsonProcessingException{
        List<PerformanceDTO> ipldata = performanceServiceInterface.getDataByTournament(TournamentName);
        return new ResponseEntity<>(ipldata, HttpStatus.OK);
    }
    @PostMapping("ipldata/CreateData")
    public ResponseEntity<?> saveEmp(@RequestBody PerformanceDTO data) throws JsonMappingException, JsonProcessingException
    {
        String dataId = performanceServiceInterface.savePlayerData(data);
        return new ResponseEntity<>(dataId, HttpStatus.OK);

    }
}
