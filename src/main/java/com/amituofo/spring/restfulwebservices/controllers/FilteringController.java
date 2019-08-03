package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.models.SomeBean;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilteringController {

  @GetMapping("/filtering")
  public SomeBean retrieveSomeBean() {
    return new SomeBean("Value1", "Value2", "Value3");
  }

  @GetMapping("/filtering-list")
  public List<SomeBean> retrieveSomeBeanList() {
    return Arrays.asList(new SomeBean[]{new SomeBean("Value1", "Value2", "Value3"), new SomeBean("Value1", "Value2", "Value3")});
  }
}
