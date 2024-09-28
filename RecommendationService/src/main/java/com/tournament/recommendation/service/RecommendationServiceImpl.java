package com.tournament.recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.tournament.recommendation.model.RecommendationDTO;
import com.tournament.recommendation.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RecommendationServiceImpl implements RecommendationServiceInterface{
	
	@Autowired
	public RecommendationRepository recommendationRepo;
	
//    @KafkaListener(topics="bookmark_data",groupId="gr1")
//    public void getMessageFromkafka(String msg) throws JsonMappingException, JsonProcessingException
//    {
//        System.out.println("*******Reading Kafka message*********");
//        ObjectMapper om=new ObjectMapper();
//        List<RecommendationDTO> ul=om.readValue(msg, new TypeReference<List<RecommendationDTO>>() {});
//        System.out.println(ul.get(0));
//    }

	@Override
	public RecommendationDTO saveRecommendation(RecommendationDTO Bookmark) {
		System.out.println("****************saveRecommendation**************"+Bookmark.getEmployeeId());
        if(Bookmark.getEmployeeId()!= null){
        	
        	RecommendationDTO bookmarkObj = new RecommendationDTO();
        	bookmarkObj.setId(Bookmark.getId());
        	bookmarkObj.setEmployeeId(Bookmark.getEmployeeId());
        	bookmarkObj.setMatches(Bookmark.getMatches());
        	bookmarkObj.setPlayer(Bookmark.getPlayer());
        	bookmarkObj.setTeam(Bookmark.getTeam());
        	bookmarkObj.setTournament(Bookmark.getTournament());
           
            return recommendationRepo.save(bookmarkObj);
        }else {
            return null;
        }
   }

	@Override
	public RecommendationDTO updateBookmark(String bookmarkid, RecommendationDTO Bookmark) {
		 Optional<RecommendationDTO> existingRecord=recommendationRepo.findById(bookmarkid);
		 
		 RecommendationDTO thisBookmark=existingRecord.get();
		 
		 thisBookmark.setId(Bookmark.getId());
		 thisBookmark.setEmployeeId(Bookmark.getEmployeeId());		 
		 thisBookmark.setTeam(Bookmark.getTeam());		 
		 thisBookmark.setPlayer(Bookmark.getPlayer());
		 thisBookmark.setMatches(Bookmark.getMatches());
		 thisBookmark.setTournament(Bookmark.getTournament());
		
	     return recommendationRepo.save(thisBookmark);
	}

	@Override
	public RecommendationDTO getBookmarkById(String bookmarkid) {
		 Optional<RecommendationDTO> bookmarkById=recommendationRepo.findById(bookmarkid);
	     return bookmarkById.get();
	}

	@Override
	public void deleteBookmarkById(String bookmarkId) {
		recommendationRepo.deleteById(bookmarkId);
	}

}
