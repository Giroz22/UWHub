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

import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.IStaffService;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/owners")
@AllArgsConstructor
@Tag(name = "Owners", description = "Operations related to managing Owners in the system")
public class OwnerController {
    @Autowired
    private ITournamentService tournamentService; 

    @Autowired
    private IStaffService staffService;

    // ======== Tournament endpoints ========
    @Operation(
        summary = "Create a new tournament",
        description = "Adds a new tournament to the system",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Tournament created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TournamentRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("/{userId}/tournaments")
    public ResponseEntity<TournamentRS> create(@PathVariable String userId, @RequestBody @Valid TournamentRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.tournamentService.create(request, userId));
    }

    @Operation(
        summary = "Update a tournament",
        description = "Updates the details of an existing tournament",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Tournament updated successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = TournamentRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Tournament not found")
        }
    )
    @PutMapping("/{ownerId}/tournament/{tournamentId}")
    public ResponseEntity<TournamentRS> update(@PathVariable String ownerId, @PathVariable String tournamentId, @RequestBody @Valid TournamentRQ request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.tournamentService.update(request, tournamentId, ownerId));
    }

    @Operation(
        summary = "Delete a tournament",
        description = "Deletes an existing tournament specified by their ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Tournament deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Tournament not found")
        }
    )
    @DeleteMapping("{ownerId}/tournament/{tournamentId}")
    public ResponseEntity<Void> delete(@PathVariable String ownerId, @PathVariable String tournamentId){
        this.tournamentService.delete(tournamentId, ownerId);
        return ResponseEntity.noContent().build();
    }

    // ======== Staff endpoints ========
    @Operation(
        summary = "Create a new staff",
        description = "Adds a new staff to the system",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "Staff created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StaffRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("/{ownerId}/tournament/{tournamentId}/staff/{userId}")
    public ResponseEntity<StaffRS> createStaff(@PathVariable String ownerId, @PathVariable String tournamentId, @PathVariable String userId) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.staffService.create(tournamentId, ownerId, userId));
    }    

    @Operation(
        summary = "Retrieve all staffs",
        description = "Gets a list of all staffs in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "List of staffs retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StaffRS.class))
            )
        }
    )
    @GetMapping("/tournament/{tournamentId}/staff")
    public ResponseEntity<List<StaffRS>> getAllStaff(@PathVariable String tournamentId) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.staffService.findAll(tournamentId));
    }

    @Operation(
        summary = "Retrieve a staff by ID",
        description = "Gets the details of a staff specified by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Staff details retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = StaffRS.class))
            ),
            @ApiResponse(responseCode = "404", description = "Staff not found")
        }
    )
    @GetMapping("/tournament/{tournamentId}/staff/{staffId}")
    public ResponseEntity<StaffRS> getStaffById(@PathVariable String tournamentId, @PathVariable String staffId) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.staffService.findById(tournamentId, staffId));
    }

    @Operation(
        summary = "Delete a staff",
        description = "Deletes an existing staff specified by their ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Staff deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Staff not found")
        }
    )
    @DeleteMapping("/{ownerId}/tournament/{tournamentId}/staff/{staffId}")
    public ResponseEntity<Void> delete(@PathVariable String tournamentId, @PathVariable String ownerId, @PathVariable String staffId){
        this.staffService.delete(tournamentId, ownerId, staffId);
        return ResponseEntity.noContent().build();
    } 
}
