package com.waveghost.uwhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.uwhub.domain.entities.TournamentEntity;

@Repository
public interface TournamentRepository extends JpaRepository<TournamentEntity, String>{
    
}
