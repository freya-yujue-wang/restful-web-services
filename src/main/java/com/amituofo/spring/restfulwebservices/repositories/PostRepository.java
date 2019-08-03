package com.amituofo.spring.restfulwebservices.repositories;

import com.amituofo.spring.restfulwebservices.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Integer> {
}
