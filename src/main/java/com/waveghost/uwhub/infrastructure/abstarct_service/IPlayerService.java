package com.waveghost.uwhub.infrastructure.abstarct_service;

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.ICreate;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IDelete;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindById;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IUpdate;

public interface IPlayerService extends 
    ICreate<PlayerRQ,PlayerRS>,
    IFindAll<PlayerRS>,
    IFindById<PlayerRS, String>,
    IUpdate<PlayerRQ,PlayerRS,String>,
    IDelete<String>
{

}
