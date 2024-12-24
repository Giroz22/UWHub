package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.StaffRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.domain.entities.StaffEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StaffMapper{
    public StaffRS entityToResponse(StaffEntity entity);
    public List<StaffRS> entityToResponse(List<StaffEntity> entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tournament", ignore = true)
    @Mapping(target = "user", ignore = true)
    public StaffEntity requestToEntity(StaffRQ request);
}
