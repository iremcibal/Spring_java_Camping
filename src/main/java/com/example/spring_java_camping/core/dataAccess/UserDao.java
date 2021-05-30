package com.example.spring_java_camping.core.dataAccess;

import com.example.spring_java_camping.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);


}
