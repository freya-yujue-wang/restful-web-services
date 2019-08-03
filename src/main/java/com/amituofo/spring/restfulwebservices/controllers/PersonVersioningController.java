package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.models.Name;
import com.amituofo.spring.restfulwebservices.models.PersonV1;
import com.amituofo.spring.restfulwebservices.models.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonVersioningController {

  @GetMapping("v1/person")
  public PersonV1 personV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping("v2/person")
  public PersonV2 personV2() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }
}
