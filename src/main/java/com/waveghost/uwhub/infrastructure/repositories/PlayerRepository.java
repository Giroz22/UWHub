package com.waveghost.uwhub.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waveghost.uwhub.infrastructure.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, String>{
    
}
