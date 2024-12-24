package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T21:14:42-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TournamentMapperImpl implements TournamentMapper {

    @Override
    public TournamentRS entityToResponse(TournamentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TournamentRS.TournamentRSBuilder tournamentRS = TournamentRS.builder();

        tournamentRS.id( entity.getId() );
        tournamentRS.name( entity.getName() );

        return tournamentRS.build();
    }

    @Override
    public List<TournamentRS> entityToResponse(List<TournamentEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TournamentRS> list = new ArrayList<TournamentRS>( entity.size() );
        for ( TournamentEntity tournamentEntity : entity ) {
            list.add( entityToResponse( tournamentEntity ) );
        }

        return list;
    }

    @Override
    public TournamentEntity requestToEntity(TournamentRQ request) {
        if ( request == null ) {
            return null;
        }

        TournamentEntity.TournamentEntityBuilder tournamentEntity = TournamentEntity.builder();

        tournamentEntity.name( request.getName() );

        return tournamentEntity.build();
    }
}
