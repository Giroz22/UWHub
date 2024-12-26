package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.StaffRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.domain.entities.StaffEntity;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import com.waveghost.uwhub.domain.entities.UserEntity;
import com.waveghost.uwhub.domain.repositories.StaffRepository;
import com.waveghost.uwhub.domain.repositories.TournamentRepository;
import com.waveghost.uwhub.domain.repositories.UserRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.IStaffService;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;
import com.waveghost.uwhub.infrastructure.abstarct_service.IUserService;
import com.waveghost.uwhub.utils.enums.RoleTourney;
import com.waveghost.uwhub.utils.exceptions.BadRequestException;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
import com.waveghost.uwhub.utils.mappers.StaffMapper;

import jakarta.transaction.Transactional;

@Service
public class StaffServiceImpl implements IStaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TournamentRepository tournamentRepository;
    
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITournamentService tournamentService;

    @Override
    @Transactional
    public StaffRS create(StaffRQ request) {
        StaffEntity staff = this.staffMapper.requestToEntity(request);
        UserEntity owner = this.userService.find(request.getOwnerId());
        UserEntity user = this.userService.find(request.getUserId());
        TournamentEntity tournament = this.tournamentService.find(request.getTournamentId());

        UserServiceImpl.validIfUserIsOwner(tournament, owner);
        this.validIfExistStaff(user, tournament);

        staff.setRole(RoleTourney.STAFF);
        staff.setUser(user);
        staff.setTournament(tournament);

        StaffEntity staffSaved = this.staffRepository.save(staff);

        return this.staffMapper.entityToResponse(staffSaved);
    }

    @Override
    public List<StaffRS> findAll(String tournamentId) {
        TournamentEntity tournament = this.tournamentService.find(tournamentId);
        
        return this.staffMapper.entityToResponse(tournament.getStaff());
    }

    @Override
    public StaffRS findById(String tournamentId, String staffId) {
        return this.staffMapper.entityToResponse(this.find(tournamentId, staffId));
    }

    @Override
    @Transactional
    public void delete(String tournamentId, String ownerId, String staffId) {

        StaffEntity staff = this.find(tournamentId, staffId);
        UserEntity owner = this.userService.find(ownerId);
        TournamentEntity tournament = this.tournamentService.find(tournamentId);
        
        UserServiceImpl.validIfUserIsOwner(tournament, owner);

        //Remove this staff of both relations
        tournament.getStaff().remove(staff);
        staff.getUser().getStaff().remove(staff);

        //Save the changes
        this.tournamentRepository.save(tournament);
        this.userRepository.save(staff.getUser());

        //Delete the staff
        this.staffRepository.delete(staff);
    }
    
    @Override
    public StaffEntity find(String tournamentId, String staffId){

        TournamentEntity tournamentEntity = this.tournamentService.find(tournamentId);
        StaffEntity staffFound = tournamentEntity.getStaff().stream()
            .filter(staff -> staff.getId().equals(staffId))
            .findFirst()
            .orElseThrow(
                () -> new IdNotFoundException("Staff", staffId)
            );

        return staffFound;
    }    

    private void validIfExistStaff(UserEntity user, TournamentEntity tournament){
        tournament.getStaff().stream().filter( staff -> staff.getUser().equals(user))
            .findFirst()
            .ifPresent(
                staff -> {
                    throw new BadRequestException(
                        String.format("The user %s is already a staff member of the tournament %s",
                            staff.getUser().getName(),
                            staff.getTournament().getName()
                        )
                    );
                }
            );
    }

}
