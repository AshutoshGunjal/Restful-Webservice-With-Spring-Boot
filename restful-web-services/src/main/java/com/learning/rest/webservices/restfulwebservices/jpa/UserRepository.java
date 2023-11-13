package com.learning.rest.webservices.restfulwebservices.jpa;

import com.learning.rest.webservices.restfulwebservices.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
