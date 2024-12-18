package com.waveghost.uwhub.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.uwhub.infrastructure.entities.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, String>{
    
}
