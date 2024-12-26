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

import com.waveghost.uwhub.api.dtos.request.StaffRQ;
import com.waveghost.uwhub.api.dtos.request.TournamentRQ;
import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.StaffRS;
import com.waveghost.uwhub.api.dtos.response.TournamentRS;
import com.waveghost.uwhub.api.dtos.response.UserRS;
import com.waveghost.uwhub.infrastructure.abstarct_service.IStaffService;
import com.waveghost.uwhub.infrastructure.abstarct_service.ITournamentService;
import com.waveghost.uwhub.infrastructure.abstarct_service.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "Users", description = "Operations related to managing users in the system")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ITournamentService tournamentService; 
    @Autowired
    private IStaffService staffService;

    // ======== User endpoints ========
    @Operation(
        summary = "Create a new user",
        description = "Adds a new user to the system",
        responses = {
            @ApiResponse(
                responseCode = "201",
                description = "User created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
        }
    )
    @PostMapping("")
    public ResponseEntity<UserRS> createUser(@Valid @RequestBody UserRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.userService.create(request));
    }    

    @Operation(
        summary = "Retrieve all users",
        description = "Gets a list of all users in the system",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "List of users retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRS.class))
            )
        }
    )
    @GetMapping("")
    public ResponseEntity<List<UserRS>> getAllUser() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.findAll());
    }

    @Operation(
        summary = "Retrieve a user by ID",
        description = "Gets the details of a user specified by their ID",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "User details retrieved successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRS.class))
            ),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserRS> getUserById(@PathVariable String id) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.findById(id));
    }
    
    @Operation(
        summary = "Update a user",
        description = "Updates the details of an existing user",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "User updated successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRS.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UserRS> updateUser(@PathVariable String id, @Valid @RequestBody UserRQ request) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.userService.update(request, id));
    }

    @Operation(
        summary = "Delete a user",
        description = "Deletes an existing user specified by their ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

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
    @PostMapping("/staff")
    public ResponseEntity<StaffRS> createStaff(@Valid @RequestBody StaffRQ request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.staffService.create(request));
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
    @GetMapping("/{ownerId}/tournament/{tournamentId}/staff/{staffId}")
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
