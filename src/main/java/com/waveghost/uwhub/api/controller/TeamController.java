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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/teams")
@AllArgsConstructor
@Tag(name = "Teams", description = "Operations related to managing teams in the system")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @Operation(
        summary = "Create a new team",
        description = "Adds a new team to the system",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Team created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("")
    public ResponseEntity<TeamRS> create(@RequestBody @Valid TeamRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.teamService.create(request));
    }    

    @Operation(
        summary = "Retrieve all teams",
        description = "Gets a list of all teams in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "List of teams retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamRS.class))
            )
        }
    )
    @GetMapping("")
    public ResponseEntity<List<TeamRS>> getAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.findAll());
    }

    @Operation(
        summary = "Retrieve a team by ID",
        description = "Gets the details of a team specified by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Team details retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamRS.class))
            ),
            @ApiResponse(responseCode = "404", description = "Team not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<TeamRS> getById(@PathVariable Integer id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.findById(id));
    }
    
    @Operation(
        summary = "Update a team",
        description = "Updates the details of an existing team",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Team updated successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TeamRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Team not found")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<TeamRS> update(@PathVariable Integer id, @RequestBody @Valid TeamRQ request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.teamService.update(request, id));
    }

    @Operation(
        summary = "Delete a team",
        description = "Deletes an existing team specified by their ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Team deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Team not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
