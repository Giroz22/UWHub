package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.TeamEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper{
    public TeamRS entityToResponse(TeamEntity entity);
    public List<TeamRS> entityToResponse(List<TeamEntity> entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "goals", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "points", ignore = true)
    @Mapping(target = "tournament", ignore = true)
    public TeamEntity requestToEntity(TeamRQ request);
}
