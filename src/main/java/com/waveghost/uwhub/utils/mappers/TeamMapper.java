package com.waveghost.uwhub.utils.mappers;

import org.mapstruct.Mapper;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper extends MapperBase<Team,TeamRQ,TeamRS>{
    
}
