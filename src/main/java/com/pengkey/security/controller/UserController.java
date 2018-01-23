package com.pengkey.security.controller;

import com.pengkey.security.dao.UserMapper;
import com.pengkey.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public User findUserById(String id){
        return userMapper.selectByPrimaryKey(Long.valueOf(id));
    }

}
