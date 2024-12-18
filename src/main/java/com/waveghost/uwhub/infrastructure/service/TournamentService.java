package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.Tournament;
import com.waveghost.uwhub.domain.repositories.TournamentRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
import com.waveghost.uwhub.utils.mappers.TournamentMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TournamentService implements ITournamentService
{
    @Autowired
    private TournamentRepository tournamentRepository;
    
    @Autowired
    private TournamentMapper tournamentMapper;

    @Override
    public TournamentRS create(TournamentRQ request) {
        Tournament tournament = this.tournamentMapper.requestToEntity(request);
        
        Tournament tournamentSaved = this.tournamentRepository.save(tournament);

        return this.tournamentMapper.entityToResponse(tournamentSaved);
    }

    @Override
    public List<TournamentRS> findAll() {
        return this.tournamentMapper.entityToResponse(this.tournamentRepository.findAll());
    }

    @Override
    public TournamentRS findById(String id) {
        Tournament tournament = this.find(id);

        return this.tournamentMapper.entityToResponse(tournament);
    }

    @Override
    public TournamentRS update(TournamentRQ requets, String id) {
        Tournament newTournament =  this.tournamentMapper.requestToEntity(requets);
        Tournament actualTournament = this.find(id);
        BeanUtils.copyProperties(newTournament, actualTournament);

        Tournament tournamentUpdated = this.tournamentRepository.save(actualTournament);

        return this.tournamentMapper.entityToResponse(tournamentUpdated);
    }

    @Override
    public void delete(String id) {
        Tournament tournament = this.find(id);
        
        this.tournamentRepository.delete(tournament);
    }

    public Tournament find(String id){
        return this.tournamentRepository.findById(id).orElseThrow(
            () -> new IdNotFoundException("Tournament", id.toString())
        );
    }
    
}
