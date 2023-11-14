package com.learning.rest.webservices.restfulwebservices.jpa;

import com.learning.rest.webservices.restfulwebservices.users.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Integer> {
}
