package com.waveghost.uwhub.infrastructure.abstarct_service;

import java.util.List;

import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.domain.entities.StaffEntity;

public interface IStaffService
{
    public StaffRS create(String tournamentId, String ownerId, String userId);
    public List<StaffRS> findAll(String tournamentId);
    public StaffRS findById(String tournamentId, String staffId);
    public StaffEntity find(String tournamentId, String staffId);
    public void delete(String tournamentId, String ownerId, String staffId);
}
