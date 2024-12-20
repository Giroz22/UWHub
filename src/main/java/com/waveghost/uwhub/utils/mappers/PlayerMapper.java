package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.entities.Player;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper{
    public PlayerRS entityToResponse(Player entity);
    public List<PlayerRS> entityToResponse(List<Player> entity);
    public Player requestToEntity(PlayerRQ request);
}
