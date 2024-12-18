package com.waveghost.uwhub.domain.abstarct_service;

import com.waveghost.uwhub.controller.dtos.request.TournamentRQ;
import com.waveghost.uwhub.controller.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.ICreate;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IDelete;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindById;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IUpdate;

public interface ITournamentService extends
    ICreate<TournamentRQ,TournamentRS>,
    IFindAll<TournamentRS>,
    IFindById<TournamentRS, String>,
    IUpdate<TournamentRQ,TournamentRS,String>,
    IDelete<String>
{
    
}
