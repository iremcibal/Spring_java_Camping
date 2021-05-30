package com.example.spring_java_camping.business.abstracts;

import com.example.spring_java_camping.core.entities.User;
import com.example.spring_java_camping.core.results.DataResult;
import com.example.spring_java_camping.core.results.Result;


public interface UserService {
    Result add(User user);
    DataResult<User> findByProductName(String email);



}
