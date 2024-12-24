package com.waveghost.uwhub.utils.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    public UserRS entityToResponse(UserEntity entity);
    public List<UserRS> entityToResponse(List<UserEntity> entity);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userTournament", ignore = true)
    public UserEntity requestToEntity(UserRQ request);
}
