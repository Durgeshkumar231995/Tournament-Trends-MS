package com.tournament.recommendation.repository;

import com.tournament.recommendation.model.RecommendationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationDTO,String>{
}
