package com.waveghost.uwhub.infrastructure.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.domain.entities.TournamentEntity;
import com.waveghost.uwhub.domain.repositories.TournamentRepository;
import com.waveghost.uwhub.utils.mappers.TournamentMapper;

@ExtendWith(MockitoExtension.class)
public class TournamentServiceImplTest {

    @Mock
    private TournamentRepository repository;

    @Mock
    private TournamentMapper mapper;
    
    @InjectMocks
    private TournamentServiceImpl serviceImpl;

    @Test
    void testCreate() {
        // //Arrange
        // TournamentRQ request = new TournamentRQ("Copa Galapagos","121");
        // TournamentEntity entity = new TournamentEntity("abc-123", "Copa Galapagos", new ArrayList<>(), new ArrayList<>());
        // TournamentRS response = new TournamentRS("abc-123", "Copa Galapagos");

        // Mockito.when(mapper.requestToEntity(Mockito.any())).thenReturn(entity);
        // Mockito.when(mapper.entityToResponse(entity)).thenReturn(response);
        // Mockito.when(repository.save(Mockito.any())).thenReturn(entity);

        // //Act
        // TournamentRS responseService = this.serviceImpl.create(request);

        // //Assert
        // assertEquals(response, responseService);
    }

    @Test
    void testUpdate() {

    }
}
