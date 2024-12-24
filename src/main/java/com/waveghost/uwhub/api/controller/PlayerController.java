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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/players")
@AllArgsConstructor
@Tag(name = "Players", description = "Operations related to managing players in the system")
public class PlayerController {

    private IPlayerService playerService;

    @Operation(
        summary = "Create a new player",
        description = "Adds a new player to the system",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Player created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("")
    public ResponseEntity<PlayerRS> create(@Valid @RequestBody PlayerRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.playerService.create(request));
    }    

    @Operation(
        summary = "Retrieve all players",
        description = "Gets a list of all players in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "List of players retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerRS.class))
            )
        }
    )
    @GetMapping("")
    public ResponseEntity<List<PlayerRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.findAll());
    }

    @Operation(
        summary = "Retrieve a player by ID",
        description = "Gets the details of a player specified by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Player details retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerRS.class))
            ),
            @ApiResponse(responseCode = "404", description = "Player not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<PlayerRS> getById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.findById(id));
    }
    
    @Operation(
        summary = "Update a player",
        description = "Updates the details of an existing player",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Player updated successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PlayerRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Player not found")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<PlayerRS> update(@PathVariable String id, @Valid @RequestBody PlayerRQ request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.playerService.update(request, id));
    }

    @Operation(
        summary = "Delete a player",
        description = "Deletes an existing player specified by their ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Player deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Player not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
