package com.learning.rest.webservices.restfulwebservices.users;

import com.learning.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResourceController {

    private UserRepository repository;
    public UserJPAResourceController(UserRepository repository) {

        this.repository = repository;
    }

    //Retrieve all users: GET /users
    @GetMapping("/jpa/users")
    public List<Users> retrieveAllUsers() {
        return repository.findAll();
    }

    //Retrieve one user: GET /users/{id} (e.g., /users/1)
    @GetMapping("/jpa/users/{id}")
    public EntityModel<Users> retrieveSpecificUser(@PathVariable int id) {

        Optional<Users> user = repository.findById(id);

        if(user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        EntityModel<Users> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    //Retrieve all posts for a specific user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {

        Optional<Users> user = repository.findById(id);

        if(user.isEmpty()) {
            throw  new UserNotFoundException("id:" + id);
        }

        return user.get().getPosts();
    }

    //Delete one user: DELETE /users/{id}
    @DeleteMapping("/jpa/users/{id}")
    public ResponseEntity<String> deleteSpecificUser(@PathVariable int id) {
        repository.deleteById(id);

        return ResponseEntity.ok("User Deleted");
    }

    //Create a user: POST /users
    @PostMapping("/jpa/users")
    public ResponseEntity<Users> createUsers(@Valid @RequestBody Users user) {
        Users savedUser = repository.save(user);

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
