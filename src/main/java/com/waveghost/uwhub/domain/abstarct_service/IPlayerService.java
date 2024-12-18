package com.waveghost.uwhub.domain.abstarct_service;

import com.waveghost.uwhub.controller.dtos.request.PlayerRQ;
import com.waveghost.uwhub.controller.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.ICreate;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IDelete;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IFindById;
import com.waveghost.uwhub.domain.abstarct_service.CRUD.IUpdate;

public interface IPlayerService extends 
    ICreate<PlayerRQ,PlayerRS>,
    IFindAll<PlayerRS>,
    IFindById<PlayerRS, String>,
    IUpdate<PlayerRQ,PlayerRS,String>,
    IDelete<String>
{
    
}
