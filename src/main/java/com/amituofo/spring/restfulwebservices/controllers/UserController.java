package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.daos.UserService;
import com.amituofo.spring.restfulwebservices.models.User;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


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
  public User retrieveUser(@PathVariable int id) {
    User user = _userService.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
    return user;
  }

  //created
  //input - details of user
  //output - created and return the created URI
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@RequestBody User user) {
    User savedUser = _userService.save(user);
    // CREATED
    // /user/4

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
