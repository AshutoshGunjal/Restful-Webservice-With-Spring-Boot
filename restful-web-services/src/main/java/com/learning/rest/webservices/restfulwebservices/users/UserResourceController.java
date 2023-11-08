package com.learning.rest.webservices.restfulwebservices.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
