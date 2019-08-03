package com.amituofo.spring.restfulwebservices.repositories;

import com.amituofo.spring.restfulwebservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
