package com.waveghost.uwhub.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/tournaments")
@AllArgsConstructor
@Tag(name = "Tournaments", description = "Operations related to managing tournaments in the system")
public class TournamentController {
    
    @Autowired
    private ITournamentService tournamentService;    

    @Operation(
        summary = "Retrieve all tournaments",
        description = "Gets a list of all tournaments in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "List of tournaments retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TournamentRS.class))
            )
        }
    )
    @GetMapping
    public ResponseEntity<List<TournamentRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.findAll());
    }

    @Operation(
        summary = "Retrieve a tournament by ID",
        description = "Gets the details of a tournament specified by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tournament details retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TournamentRS.class))
            ),
            @ApiResponse(responseCode = "404", description = "Tournament not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<TournamentRS> getById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.findById(id));
    }    
}