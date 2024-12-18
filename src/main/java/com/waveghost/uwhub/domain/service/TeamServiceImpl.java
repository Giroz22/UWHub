package com.waveghost.uwhub.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.waveghost.uwhub.controller.dtos.request.TeamRQ;
import com.waveghost.uwhub.controller.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.abstarct_service.ITeamService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements ITeamService
{

    @Override
    public TeamRS create(TeamRQ request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<TeamRS> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public TeamRS findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TeamRS update(TeamRQ requets, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
