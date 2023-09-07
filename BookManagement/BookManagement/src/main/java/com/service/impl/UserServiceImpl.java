package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User getByVistorsname(String vistorsname) {
        return userDao.getByVistorsname(vistorsname);
    }
}
