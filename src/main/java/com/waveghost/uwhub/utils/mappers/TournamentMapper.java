package com.waveghost.uwhub.utils.mappers;

import org.mapstruct.Mapper;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.infrastructure.entities.Tournament;

@Mapper(componentModel = "spring")
public interface TournamentMapper extends MapperBase<Tournament,TournamentRQ,TournamentRS>{
    
}
