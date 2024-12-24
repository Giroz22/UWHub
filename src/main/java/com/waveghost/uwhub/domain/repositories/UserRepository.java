package com.waveghost.uwhub.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waveghost.uwhub.domain.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
    
}
