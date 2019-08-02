package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.models.User;
import com.amituofo.spring.restfulwebservices.services.UserService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
public class UserController {

  @Autowired
  private UserService _userService;

  //retrieveALlUsers
  @GetMapping("/users")
  public List<User> retrieveALlUsers() {
    return _userService.findAll();
  }

  //retrieveUser(int id)
  @GetMapping("/users/{id}")
  public Resource<User> retrieveUser(@PathVariable int id) {
    User user = _userService.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }

    //"all-user", SERVER_PATH + "/users/"
    //retrieveAllUsers
    Resource<User> resource = new Resource<>(user);

    ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveALlUsers());

    resource.add(linkBuilder.withRel("all-users"));

    return resource;
  }

  //created
  //input - details of user
  //output - created and return the created URI
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = _userService.save(user);
    // CREATED
    // /user/4

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  //retrieveUser(int id)
  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user = _userService.delete(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
  }
}
