package com.learning.rest.webservices.restfulwebservices.users;

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
    public Users retrieveSpecificUser(@PathVariable int id) {
        Users user = service.findSpecificUser(id);

        if(user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        return user;
    }

    //Create a user: POST /users
    @PostMapping("/users")
    public ResponseEntity<Users> createUsers(@RequestBody Users user) {
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
