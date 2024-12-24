package com.waveghost.uwhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waveghost.uwhub.domain.entities.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, String>{
    
}
