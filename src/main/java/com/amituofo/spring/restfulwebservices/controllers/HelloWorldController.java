package com.amituofo.spring.restfulwebservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

  @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  //hello-world-bean
  @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World");
  }

  //hello-world/path-variable
  @RequestMapping(method = RequestMethod.GET, path = "/hello-world/path-variable/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello World, %s", name));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/hello-world-i18n")
  public String helloWorldI18n() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }
}
