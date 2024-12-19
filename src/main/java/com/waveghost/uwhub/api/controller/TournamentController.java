package com.waveghost.uwhub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/tournaments")
@AllArgsConstructor
public class TournamentController {
    
    @Autowired
    private ITournamentService tournamentService;

    @PostMapping("")
    public ResponseEntity<TournamentRS> create(@RequestBody TournamentRQ entity) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.tournamentService.create(entity));
    }    

    @GetMapping("")
    public ResponseEntity<List<TournamentRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentRS> getById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TournamentRS> update(@PathVariable String id, @RequestBody TournamentRQ entity) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.update(entity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.tournamentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
