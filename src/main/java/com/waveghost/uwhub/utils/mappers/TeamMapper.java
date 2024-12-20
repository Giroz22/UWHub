package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper{
    public TeamRS entityToResponse(Team entity);
    public List<TeamRS> entityToResponse(List<Team> entity);
    public Team requestToEntity(TeamRQ request);
}
