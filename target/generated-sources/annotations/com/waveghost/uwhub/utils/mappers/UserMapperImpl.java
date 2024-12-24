package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-24T11:48:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserRS entityToResponse(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserRS.UserRSBuilder userRS = UserRS.builder();

        userRS.email( entity.getEmail() );
        userRS.id( entity.getId() );
        userRS.name( entity.getName() );

        return userRS.build();
    }

    @Override
    public List<UserRS> entityToResponse(List<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserRS> list = new ArrayList<UserRS>( entity.size() );
        for ( UserEntity userEntity : entity ) {
            list.add( entityToResponse( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity requestToEntity(UserRQ request) {
        if ( request == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( request.getEmail() );
        userEntity.name( request.getName() );
        userEntity.passsword( request.getPasssword() );

        return userEntity.build();
    }
}
