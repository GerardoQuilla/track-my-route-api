package com.innovatech.authentication.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.innovatech.authentication.domain.model.commands.DeleteUserCommand;
import com.innovatech.authentication.domain.model.queries.GetAllUsersQuery;
import com.innovatech.authentication.domain.model.queries.GetUserByIdQuery;
import com.innovatech.authentication.domain.services.UserCommandService;
import com.innovatech.authentication.domain.services.UserQueryService;
import com.innovatech.authentication.interfaces.rest.resources.UserResource;
import com.innovatech.authentication.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;


/**
 * This class is a REST controller that exposes the users resource.
 * It includes the following operations:
 * - GET /api/v1/users: returns all the users
 * - GET /api/v1/users/{userId}: returns the user with the given id
 **/
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "User Management Endpoints")
public class UsersController {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UsersController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    /**
     * This method returns all the users.
     * @return a list of user resources
     * @see UserResource
     */
    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var userResources = users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResources);
    }

    /**
     * This method returns the user with the given id.
     * @param userId the user id
     * @return the user resource with the given id
     * @throws RuntimeException if the user is not found
     * @see UserResource
     */
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<UserResource> deleteUser(@PathVariable String username) {
        var deleteUserCommand = new DeleteUserCommand(username);
        var user = userCommandService.handle(deleteUserCommand);

        var resource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<UserResource>(resource, HttpStatus.ACCEPTED);
    }
}