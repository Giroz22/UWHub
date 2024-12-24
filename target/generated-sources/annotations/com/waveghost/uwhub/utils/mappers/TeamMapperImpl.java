package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T17:59:10-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamRS entityToResponse(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamRS.TeamRSBuilder teamRS = TeamRS.builder();

        teamRS.goals( entity.getGoals() );
        teamRS.id( entity.getId() );
        teamRS.name( entity.getName() );
        teamRS.points( entity.getPoints() );

        return teamRS.build();
    }

    @Override
    public List<TeamRS> entityToResponse(List<Team> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TeamRS> list = new ArrayList<TeamRS>( entity.size() );
        for ( Team team : entity ) {
            list.add( entityToResponse( team ) );
        }

        return list;
    }

    @Override
    public Team requestToEntity(TeamRQ request) {
        if ( request == null ) {
            return null;
        }

        Team.TeamBuilder team = Team.builder();

        team.name( request.getName() );

        return team.build();
    }
}
