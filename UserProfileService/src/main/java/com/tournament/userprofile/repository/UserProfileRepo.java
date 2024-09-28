package com.tournament.userprofile.repository;

import com.tournament.userprofile.model.userProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<userProfile,Integer>{

}
