package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findById(long id);
    Users findByUsername(String username);
}
