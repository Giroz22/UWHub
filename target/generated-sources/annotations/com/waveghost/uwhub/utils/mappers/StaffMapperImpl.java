package com.waveghost.uwhub.utils.mappers;

import com.waveghost.uwhub.api.dtos.request.StaffRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.domain.entities.StaffEntity;
import com.waveghost.uwhub.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-25T17:11:45-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public StaffRS entityToResponse(StaffEntity entity) {
        if ( entity == null ) {
            return null;
        }

        StaffRS.StaffRSBuilder staffRS = StaffRS.builder();

        staffRS.id( entity.getId() );
        staffRS.role( entity.getRole() );
        staffRS.user( userEntityToUserRS( entity.getUser() ) );

        return staffRS.build();
    }

    @Override
    public List<StaffRS> entityToResponse(List<StaffEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<StaffRS> list = new ArrayList<StaffRS>( entity.size() );
        for ( StaffEntity staffEntity : entity ) {
            list.add( entityToResponse( staffEntity ) );
        }

        return list;
    }

    @Override
    public StaffEntity requestToEntity(StaffRQ request) {
        if ( request == null ) {
            return null;
        }

        StaffEntity.StaffEntityBuilder staffEntity = StaffEntity.builder();

        return staffEntity.build();
    }

    protected UserRS userEntityToUserRS(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserRS.UserRSBuilder userRS = UserRS.builder();

        userRS.email( userEntity.getEmail() );
        userRS.id( userEntity.getId() );
        userRS.name( userEntity.getName() );

        return userRS.build();
    }
}
