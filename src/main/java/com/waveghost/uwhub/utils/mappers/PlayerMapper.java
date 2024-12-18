package com.waveghost.uwhub.utils.mappers;

import org.mapstruct.Mapper;

import com.waveghost.uwhub.controller.dtos.request.PlayerRQ;
import com.waveghost.uwhub.controller.dtos.response.PlayerRS;
import com.waveghost.uwhub.infrastructure.entities.Player;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends MapperBase<Player,PlayerRQ,PlayerRS>{
    
}
