package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.Tournament;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-20T18:21:37-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.40.0.z20241112-1021, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TournamentMapperImpl implements TournamentMapper {

    @Override
    public TournamentRS entityToResponse(Tournament entity) {
        if ( entity == null ) {
            return null;
        }

        TournamentRS.TournamentRSBuilder tournamentRS = TournamentRS.builder();

        tournamentRS.id( entity.getId() );
        tournamentRS.name( entity.getName() );

        return tournamentRS.build();
    }

    @Override
    public List<TournamentRS> entityToResponse(List<Tournament> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TournamentRS> list = new ArrayList<TournamentRS>( entity.size() );
        for ( Tournament tournament : entity ) {
            list.add( entityToResponse( tournament ) );
        }

        return list;
    }

    @Override
    public Tournament requestToEntity(TournamentRQ request) {
        if ( request == null ) {
            return null;
        }

        Tournament.TournamentBuilder tournament = Tournament.builder();

        tournament.name( request.getName() );

        return tournament.build();
    }
}
