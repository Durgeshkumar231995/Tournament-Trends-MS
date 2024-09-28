package com.tournament.performance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tournament.performance.model.PerformanceDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PerformanceServiceInterface {
   public List<PerformanceDTO>  getAllData() throws JsonProcessingException;
   public List<PerformanceDTO> getDataByPlayer(String Player) throws JsonProcessingException;
   public List<PerformanceDTO> getDataByTeam(String Team) throws JsonProcessingException;
   public List<PerformanceDTO> getDataByTournament(String Tournament) throws JsonProcessingException;
   public String savePlayerData(PerformanceDTO data) throws JsonProcessingException;
}
