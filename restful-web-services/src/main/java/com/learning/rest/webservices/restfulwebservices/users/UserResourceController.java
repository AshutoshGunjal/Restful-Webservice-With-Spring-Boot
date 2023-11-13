package com.learning.rest.webservices.restfulwebservices.users;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    private UserDAOService service;

    public UserResourceController(UserDAOService service) {
        this.service = service;
    }

    //Retrieve all users: GET /users
    @GetMapping("/users")
    public List<Users> retrieveAllUsers() {
        return service.findAllUsers();
    }

    //Retrieve one user: GET /users/{id} (e.g., /users/1)
    @GetMapping("/users/{id}")
    public EntityModel<Users> retrieveSpecificUser(@PathVariable int id) {
        Users user = service.findSpecificUser(id);

        if(user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<Users> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    //Delete one user: DELETE /users/{id}
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteSpecificUser(@PathVariable int id) {
        service.deleteSpecificUserById(id);

        return ResponseEntity.ok("User Deleted");
    }

    //Create a user: POST /users
    @PostMapping("/users")
    public ResponseEntity<Users> createUsers(@Valid @RequestBody Users user) {
        Users savedUser = service.save(user);

        /*return URI of the created resource
            For example: /users/4 => /users/{id},    users.getID();
        */
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
