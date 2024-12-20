package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.Tournament;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TournamentMapper{
    public TournamentRS entityToResponse(Tournament entity);
    public List<TournamentRS> entityToResponse(List<Tournament> entity);
    public Tournament requestToEntity(TournamentRQ request);
}
