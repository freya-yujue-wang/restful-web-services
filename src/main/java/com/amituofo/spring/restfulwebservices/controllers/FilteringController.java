package com.amituofo.spring.restfulwebservices.controllers;

import com.amituofo.spring.restfulwebservices.models.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilteringController {

  //Return only Field1, Field2
  @GetMapping("/filtering")
  public MappingJacksonValue retrieveSomeBean() {
    SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
    return decorateWithFilters(someBean, "field1", "field2");
  }

  //Return only Field2, Field3
  @GetMapping("/filtering-list")
  public MappingJacksonValue retrieveSomeBeanList() {
    List<SomeBean> someBeans = Arrays.asList(
        new SomeBean[]{new SomeBean("Value1", "Value2", "Value3"), new SomeBean("Value1", "Value2", "Value3")});
    return decorateWithFilters(someBeans, "field2", "field3");
  }

  private MappingJacksonValue decorateWithFilters(Object object, String... fields) {
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
    FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
    MappingJacksonValue mapping = new MappingJacksonValue(object);
    mapping.setFilters(filters);
    return mapping;
  }
}
