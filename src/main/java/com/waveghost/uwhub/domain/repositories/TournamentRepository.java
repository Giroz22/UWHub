package com.waveghost.uwhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.uwhub.domain.entities.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, String>{
    
}
