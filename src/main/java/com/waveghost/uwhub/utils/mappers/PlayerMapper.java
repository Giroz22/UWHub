package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.entities.PlayerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper{
    public PlayerRS entityToResponse(PlayerEntity entity);
    public List<PlayerRS> entityToResponse(List<PlayerEntity> entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    public PlayerEntity requestToEntity(PlayerRQ request);
}
