package com.belle.springboot.service.impl;

import com.belle.springboot.dao.LoginUserDAO;
import com.belle.springboot.pojo.LoginUser;
import com.belle.springboot.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    private LoginUserDAO loginUserDAO;

    @Override
    public LoginUser login(LoginUser loginUser) {
        System.err.println (loginUser);
        System.err.println (loginUserDAO.login (loginUser));
        return loginUserDAO.login (loginUser);
    }
}
