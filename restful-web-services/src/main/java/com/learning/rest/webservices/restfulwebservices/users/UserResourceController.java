package com.learning.rest.webservices.restfulwebservices.users;

import org.springframework.web.bind.annotation.*;

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
        return service.findSpecificUser(id);
    }

    //Create a user: POST /users
    @PostMapping("/users")
    public void createUsers(@RequestBody Users user) {
        service.save(user);
    }
}
