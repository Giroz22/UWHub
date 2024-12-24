package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper{
    public TeamRS entityToResponse(Team entity);
    public List<TeamRS> entityToResponse(List<Team> entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "goals", ignore = true)
    @Mapping(target = "players", ignore = true)
    @Mapping(target = "points", ignore = true)
    @Mapping(target = "tournament", ignore = true)
    public Team requestToEntity(TeamRQ request);
}
