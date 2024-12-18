package com.waveghost.uwhub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.domain.abstarct_service.ITournamentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/tournaments")
@AllArgsConstructor
public class TournamentController {
    
    @Autowired
    private ITournamentService tournamentService;
}
