package com.waveghost.uwhub.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.waveghost.uwhub.controller.dtos.request.TournamentRQ;
import com.waveghost.uwhub.controller.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.abstarct_service.ITournamentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TournamentService implements ITournamentService
{

    @Override
    public TournamentRS create(TournamentRQ request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<TournamentRS> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public TournamentRS findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TournamentRS update(TournamentRQ requets, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
