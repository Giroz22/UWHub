package com.waveghost.uwhub.infrastructure.abstarct_service;

import java.util.List;

import com.waveghost.uwhub.api.dtos.request.StaffRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.domain.entities.StaffEntity;
import com.waveghost.uwhub.infrastructure.abstarct_service.CRUD.ICreate;

public interface IStaffService extends 
    ICreate<StaffRQ,StaffRS>
{
    public List<StaffRS> findAll(String tournamentId);
    public StaffRS findById(String tournamentId, String staffId);
    public StaffEntity find(String tournamentId, String staffId);
    public void delete(String tournamentId, String ownerId, String staffId);

}
