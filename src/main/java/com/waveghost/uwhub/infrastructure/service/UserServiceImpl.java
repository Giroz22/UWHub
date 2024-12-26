package com.waveghost.uwhub.infrastructure.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import com.waveghost.uwhub.domain.entities.UserEntity;
import com.waveghost.uwhub.domain.repositories.UserRepository;
import com.waveghost.uwhub.infrastructure.abstarct_service.IUserService;
import com.waveghost.uwhub.utils.exceptions.BadRequestException;
import com.waveghost.uwhub.utils.exceptions.IdNotFoundException;
import com.waveghost.uwhub.utils.mappers.UserMapper;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserRS create(UserRQ request) {
        UserEntity user = this.userMapper.requestToEntity(request);

        UserEntity userSaved = this.userRepository.save(user);

        return this.userMapper.entityToResponse(userSaved);
    }

    @Override
    public List<UserRS> findAll() {
        return this.userMapper.entityToResponse(this.userRepository.findAll());
    }

    @Override
    public UserRS findById(String id) {
        return this.userMapper.entityToResponse(this.find(id));
    }

    @Override
    public UserRS update(UserRQ requets, String id) {
        UserEntity userUpdate = this.userMapper.requestToEntity(requets);
        UserEntity userNow = this.find(id);

        BeanUtils.copyProperties(userUpdate, userNow);

        UserEntity userUpdated = this.userRepository.save(userNow);

        return this.userMapper.entityToResponse(userUpdated);
    }

    @Override
    public void delete(String id) {
        UserEntity user = this.find(id);

        this.userRepository.delete(user);
    }
    
    @Override
    public UserEntity find(String id){
        return this.userRepository.findById(id).orElseThrow(
            () -> new IdNotFoundException("User", id)
        );
    }

    public static void validIfUserIsOwner(TournamentEntity tournament, UserEntity user){
        if(!tournament.getOwner().equals(user)) 
            throw new BadRequestException(
                String.format("The user %s is not the owner of the tournament %s",
                    user.getName(), 
                    tournament.getName()
                )
            );
    }
}
