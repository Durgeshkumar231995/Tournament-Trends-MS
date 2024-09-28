package com.tournament.recommendation.controller;

import com.tournament.recommendation.model.RecommendationDTO;
import com.tournament.recommendation.service.RecommendationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3")
public class RecommendationController {
	
    @Autowired
    private RecommendationServiceInterface recommendationService;
    

    @PostMapping("/createBookmark")
    public ResponseEntity<?> saveRecommendation(@RequestBody RecommendationDTO Bookmark) {
    	RecommendationDTO savedBookmark = recommendationService.saveRecommendation(Bookmark);
        if(savedBookmark!= null){
//            kafkaService.sendDataToAuthenticationService(savedRecommendation);
            return new ResponseEntity<>(savedBookmark,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Error saving the Bookmark!",HttpStatus.OK);
        }
    }
    @PutMapping("updateBookmark/{bookmarkid}")
    public ResponseEntity<?> updateRecommendation(@PathVariable String bookmarkid,@RequestBody RecommendationDTO Bookmark){
        return new ResponseEntity<>(recommendationService.updateBookmark(bookmarkid, Bookmark),HttpStatus.OK);
    }
    @GetMapping("/getBookmark/{bookmarkid}")
    public ResponseEntity<?> getBookmarkyId(@PathVariable String bookmarkid){
        RecommendationDTO updatedBookmark=recommendationService.getBookmarkById(bookmarkid);
        return new ResponseEntity<>(updatedBookmark,HttpStatus.OK);
    }
    @DeleteMapping("deleteBookmark/{bookmarkId}")
    public String deleteBookmarkById(@PathVariable String bookmarkId){
        recommendationService.deleteBookmarkById(bookmarkId);
        return "Deleted";
    }
    
}
