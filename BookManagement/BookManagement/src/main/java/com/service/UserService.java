package com.service;

import com.domain.User;

public interface UserService {

    public User getByUsername(String username);

    public User getByVistorsname(String vistorsname);
}
