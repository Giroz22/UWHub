package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TournamentMapper{
    public TournamentRS entityToResponse(TournamentEntity entity);
    public List<TournamentRS> entityToResponse(List<TournamentEntity> entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teams", ignore = true)
    public TournamentEntity requestToEntity(TournamentRQ request);
}
