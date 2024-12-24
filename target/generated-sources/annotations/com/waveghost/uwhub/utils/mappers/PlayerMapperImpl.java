package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.domain.entities.PlayerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-24T15:07:45-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerRS entityToResponse(PlayerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PlayerRS.PlayerRSBuilder playerRS = PlayerRS.builder();

        playerRS.id( entity.getId() );
        playerRS.name( entity.getName() );
        playerRS.number( entity.getNumber() );
        playerRS.position( entity.getPosition() );

        return playerRS.build();
    }

    @Override
    public List<PlayerRS> entityToResponse(List<PlayerEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<PlayerRS> list = new ArrayList<PlayerRS>( entity.size() );
        for ( PlayerEntity playerEntity : entity ) {
            list.add( entityToResponse( playerEntity ) );
        }

        return list;
    }

    @Override
    public PlayerEntity requestToEntity(PlayerRQ request) {
        if ( request == null ) {
            return null;
        }

        PlayerEntity.PlayerEntityBuilder playerEntity = PlayerEntity.builder();

        playerEntity.name( request.getName() );
        playerEntity.number( request.getNumber() );
        playerEntity.position( request.getPosition() );

        return playerEntity.build();
    }
}
