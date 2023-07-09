package com.security.sample.securitytest.repository;

import com.security.sample.securitytest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
     User findByUsername(String username);
}
