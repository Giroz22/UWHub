package com.waveghost.uwhub.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.domain.abstarct_service.IPlayerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/players")
@AllArgsConstructor
public class PlayerController {
    private IPlayerService playerService;
}
