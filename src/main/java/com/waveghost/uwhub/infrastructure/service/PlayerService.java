package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.entities.Player;
import com.waveghost.uwhub.domain.repositories.PlayerRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.IPlayerService;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
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
        Player player = this.playerMapper.requestToEntity(request);

        Player playerSaved = this.playerRepository.save(player);

        return this.playerMapper.entityToResponse(playerSaved);
    }

    @Override
    public List<PlayerRS> findAll() {
        return this.playerMapper.entityToResponse(this.playerRepository.findAll());
    }

    @Override
    public PlayerRS findById(String id) {
        return this.playerMapper.entityToResponse(this.find(id));
    }

    @Override
    public PlayerRS update(PlayerRQ requets, String id) {
        Player playerUpdate = this.playerMapper.requestToEntity(requets);
        Player playerNow = this.find(id);

        BeanUtils.copyProperties(playerUpdate, playerNow);

        Player playerUpdated = this.playerRepository.save(playerNow);

        return this.playerMapper.entityToResponse(playerUpdated);
    }

    @Override
    public void delete(String id) {
        Player player = this.find(id);

        this.playerRepository.delete(player);
    }
    
    private Player find(String id){
        return this.playerRepository.findById(id).orElseThrow(
            () -> new IdNotFoundException("Team", id)
        );
    }
}
