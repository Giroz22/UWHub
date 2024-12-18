package com.waveghost.uwhub.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.controller.dtos.request.PlayerRQ;
import com.waveghost.uwhub.controller.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.abstarct_service.IPlayerService;
import com.waveghost.uwhub.infrastructure.repositories.PlayerRepository;
import com.waveghost.uwhub.utils.mappers.PlayerMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerService implements IPlayerService
{

    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public PlayerRS create(PlayerRQ request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<PlayerRS> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public PlayerRS findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public PlayerRS update(PlayerRQ requets, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
