package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import com.waveghost.uwhub.domain.entities.UserEntity;
import com.waveghost.uwhub.domain.repositories.TournamentRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;
import com.waveghost.uwhub.infrastructure.abstarct_service.IUserService;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
import com.waveghost.uwhub.utils.mappers.TournamentMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TournamentServiceImpl implements ITournamentService
{
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentMapper tournamentMapper;

    @Autowired
    private IUserService userService;

    @Override
    @Transactional
    public TournamentRS create(TournamentRQ request, String userId) {
        TournamentEntity tournament = this.tournamentMapper.requestToEntity(request);
        
        UserEntity owner = this.userService.find(userId);
        tournament.setOwner(owner);

        //Validations
        UserServiceImpl.validIfUserIsOwner(tournament, owner);

        TournamentEntity tournamentSaved = this.tournamentRepository.save(tournament);
        
        return this.tournamentMapper.entityToResponse(this.find(tournamentSaved.getId()));
    }

    @Override
    public List<TournamentRS> findAll() {
        return this.tournamentMapper.entityToResponse(this.tournamentRepository.findAll());
    }

    @Override
    public TournamentRS findById(String id) {
        TournamentEntity tournament = this.find(id);

        return this.tournamentMapper.entityToResponse(tournament);
    }

    @Override
    @Transactional
    public TournamentRS update(TournamentRQ requets, String tournamentId, String ownerId ) {
        UserEntity owner = this.userService.find(ownerId);
        TournamentEntity tournamentActual = this.find(tournamentId);
        
        BeanUtils.copyProperties(requets, tournamentActual);

        //Validations
        UserServiceImpl.validIfUserIsOwner(tournamentActual, owner);

        TournamentEntity tournamentUpdated = this.tournamentRepository.save(tournamentActual);

        return this.tournamentMapper.entityToResponse(tournamentUpdated);
    }

    @Override
    @Transactional
    public void delete(String tournamentId, String ownerId) {
        TournamentEntity tournament = this.find(tournamentId);
        UserEntity owner = this.userService.find(ownerId);

        //Validations
        UserServiceImpl.validIfUserIsOwner(tournament, owner);
        
        this.tournamentRepository.delete(tournament);
    }

    public TournamentEntity find(String tournamentId){
        return this.tournamentRepository.findById(tournamentId).orElseThrow(
            () -> new IdNotFoundException("Tournament", tournamentId.toString())
        );
    }
    
}
