package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.daos.UserService;
import com.amituofo.spring.restfulwebservices.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    return _userService.findOne(id);
  }

  //created
  //input - details of user
  //output - created and return the created URI
  @PostMapping("/users")
  public void createUser(@RequestBody User user) {
    User savedUser = _userService.save(user);
  }
}
