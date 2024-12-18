package com.waveghost.uwhub.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waveghost.uwhub.infrastructure.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, String>{
    
}
