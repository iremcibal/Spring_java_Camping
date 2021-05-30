package com.example.spring_java_camping.business.concretes;

import com.example.spring_java_camping.business.abstracts.UserService;
import com.example.spring_java_camping.core.dataAccess.UserDao;
import com.example.spring_java_camping.core.entities.User;
import com.example.spring_java_camping.core.results.DataResult;
import com.example.spring_java_camping.core.results.Result;
import com.example.spring_java_camping.core.results.SuccessDataResult;
import com.example.spring_java_camping.core.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi.");
    }

    @Override
    public DataResult<User> findByProductName(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email),"Kullanıcı Bulundu.");
    }
}
