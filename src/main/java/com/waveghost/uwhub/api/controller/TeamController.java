package com.waveghost.uwhub.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.infrastructure.abstarct_service.ITeamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/teams")
@AllArgsConstructor
public class TeamController {
    @Autowired
    private ITeamService teamService;
}
