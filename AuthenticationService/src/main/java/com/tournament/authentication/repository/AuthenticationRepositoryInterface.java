package com.tournament.authentication.repository;

import com.tournament.authentication.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepositoryInterface extends JpaRepository<Authentication, Integer> {
    public Authentication findByEmailAndPassword(String email, String password);
}
