package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.TeamEntity;
import com.waveghost.uwhub.domain.repositories.TeamRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITeamService;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
import com.waveghost.uwhub.utils.mappers.TeamMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements ITeamService
{

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public TeamRS create(TeamRQ request) {
        TeamEntity team = this.teamMapper.requestToEntity(request);
        team.setPoints(0);
        team.setGoals(0);
        
        TeamEntity teamSaved = this.teamRepository.save(team);

        return this.teamMapper.entityToResponse(teamSaved);
    }

    @Override
    public List<TeamRS> findAll() {
        return this.teamMapper.entityToResponse(this.teamRepository.findAll());
    }

    @Override
    public TeamRS findById(Integer id) {
        TeamEntity team = this.find(id);

        return this.teamMapper.entityToResponse(team);
    }

    @Override
    public TeamRS update(TeamRQ requets, Integer id) {
        TeamEntity newTeam =  this.teamMapper.requestToEntity(requets);
        TeamEntity actualTeam = this.find(id);
        BeanUtils.copyProperties(newTeam, actualTeam);

        TeamEntity teamUpdated = this.teamRepository.save(actualTeam);

        return this.teamMapper.entityToResponse(teamUpdated);
    }

    @Override
    public void delete(Integer id) {
        TeamEntity team = this.find(id);
        
        this.teamRepository.delete(team);
    }

    public TeamEntity find(Integer id){
        return this.teamRepository.findById(id).orElseThrow(
            () -> new IdNotFoundException("Team", id.toString())
        );
    }
}
