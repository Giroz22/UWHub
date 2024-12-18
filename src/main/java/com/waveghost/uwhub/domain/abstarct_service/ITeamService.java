package com.waveghost.uwhub.domain.abstarct_service;

import com.waveghost.uwhub.controller.dtos.request.TeamRQ;
import com.waveghost.uwhub.controller.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.ICreate;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IDelete;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindById;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IUpdate;

public interface ITeamService extends 
    ICreate<TeamRQ,TeamRS>,
    IFindAll<TeamRS>,
    IFindById<TeamRS, Integer>,
    IUpdate<TeamRQ,TeamRS,Integer>,
    IDelete<Integer>
{
}
