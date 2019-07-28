package com.amituofo.spring.restfulwebservices.daos;

import com.amituofo.spring.restfulwebservices.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class UserService {
  private static List<User> users = new ArrayList<>();

  private static int maxId = 3;

  static {
    users.add(new User(1, "Adam", LocalDate.now()));
    users.add(new User(2, "Eve", LocalDate.now()));
    users.add(new User(3, "Jack", LocalDate.now()));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user) {
    if(user.getId() == null) {
      user.setId(++maxId);
    }
    users.add(user);
    return user;
  }

  public User findOne(int id) {
    for(User user : users) {
      if(user.getId() == id) {
        return user;
      }
    }

    return null;
  }
}
