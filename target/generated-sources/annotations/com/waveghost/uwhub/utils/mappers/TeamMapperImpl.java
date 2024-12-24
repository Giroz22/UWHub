package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.domain.entities.TeamEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T21:00:08-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamRS entityToResponse(TeamEntity entity) {
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
    public List<TeamRS> entityToResponse(List<TeamEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TeamRS> list = new ArrayList<TeamRS>( entity.size() );
        for ( TeamEntity teamEntity : entity ) {
            list.add( entityToResponse( teamEntity ) );
        }

        return list;
    }

    @Override
    public TeamEntity requestToEntity(TeamRQ request) {
        if ( request == null ) {
            return null;
        }

        TeamEntity.TeamEntityBuilder teamEntity = TeamEntity.builder();

        teamEntity.name( request.getName() );

        return teamEntity.build();
    }
}
