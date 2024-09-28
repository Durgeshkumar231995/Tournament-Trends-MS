package com.tournament.recommendation.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tournament.recommendation.model.RecommendationDTO;

public interface RecommendationServiceInterface {
//   public void getMessageFromkafka(String msg)throws JsonMappingException, JsonProcessingException;
	
	public RecommendationDTO saveRecommendation(RecommendationDTO Bookmark);
	public RecommendationDTO updateBookmark(String bookmarkid,RecommendationDTO Bookmark);
	public RecommendationDTO getBookmarkById(String bookmarkid);
	public void deleteBookmarkById(String bookmarkId);
}
