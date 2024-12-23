package com.waveghost.uwhub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.api.dtos.request.TeamRQ;
import com.waveghost.uwhub.api.dtos.response.TeamRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITeamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/teams")
@AllArgsConstructor
public class TeamController {
    @Autowired
    private ITeamService teamService;

    @PostMapping("")
    public ResponseEntity<TeamRS> create(@RequestBody TeamRQ entity) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.teamService.create(entity));
    }    

    @GetMapping("")
    public ResponseEntity<List<TeamRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamRS> getById(@PathVariable Integer id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TeamRS> update(@PathVariable Integer id, @RequestBody TeamRQ entity) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.update(entity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
