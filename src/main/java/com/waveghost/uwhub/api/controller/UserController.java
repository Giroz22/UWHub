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

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    private IUserService userService;

    @PostMapping("")
    public ResponseEntity<UserRS> create(@RequestBody UserRQ entity) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.userService.create(entity));
    }    

    @GetMapping("")
    public ResponseEntity<List<UserRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRS> getById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserRS> update(@PathVariable String id, @RequestBody UserRQ entity) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.update(entity, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
