package com.waveghost.uwhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waveghost.uwhub.domain.entities.StaffEntity;

public interface UserTourneyRepository extends JpaRepository<StaffEntity, String>{
    
}
