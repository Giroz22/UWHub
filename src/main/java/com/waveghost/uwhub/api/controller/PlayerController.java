package com.waveghost.uwhub.api.controller;

import java.util.List;

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

import com.waveghost.uwhub.api.dtos.request.PlayerRQ;
import com.waveghost.uwhub.api.dtos.response.PlayerRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.IPlayerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/players")
@AllArgsConstructor
public class PlayerController {
    private IPlayerService playerService;

    @PostMapping("")
    public ResponseEntity<PlayerRS> create(@Valid @RequestBody PlayerRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.playerService.create(request));
    }    

    @GetMapping("")
    public ResponseEntity<List<PlayerRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerRS> getById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PlayerRS> update(@PathVariable String id, @Valid @RequestBody PlayerRQ request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
