package com.waveghost.uwhub.infrastructure.abstarct_service;

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.ICreate;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IDelete;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindAll;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IFindById;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.IUpdate;

public interface IUserService extends 
    ICreate<UserRQ,UserRS>,
    IFindAll<UserRS>,
    IFindById<UserRS, String>,
    IUpdate<UserRQ,UserRS,String>,
    IDelete<String>
{
    
}
