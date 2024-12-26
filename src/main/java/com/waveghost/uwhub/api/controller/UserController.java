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

import com.waveghost.uwhub.api.dtos.request.UserRQ;
import com.waveghost.uwhub.api.dtos.response.UserRS;
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
}
