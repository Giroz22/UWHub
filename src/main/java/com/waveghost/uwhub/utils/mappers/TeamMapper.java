package com.waveghost.uwhub.utils.mappers;

import org.mapstruct.Mapper;

import com.waveghost.uwhub.controller.dtos.request.TeamRQ;
import com.waveghost.uwhub.controller.dtos.response.TeamRS;
import com.waveghost.uwhub.infrastructure.entities.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper extends MapperBase<Team,TeamRQ,TeamRS>{
    
}
