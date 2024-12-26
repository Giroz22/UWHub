package com.waveghost.uwhub.infrastructure.abstarct_service;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFind;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindById;

public interface ITournamentService extends
    IFindAll<TournamentRS>,
    IFindById<TournamentRS, String>,
    IFind<TournamentEntity, String>    
{
    public TournamentRS create(TournamentRQ request, String userId);
    public TournamentRS update(TournamentRQ requets, String tournamentId, String ownerId);
    public void delete(String tournamentId, String ownerId);
}
