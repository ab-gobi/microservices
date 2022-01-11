package com.gobiab.userservice.controller;

import com.gobiab.userservice.VO.ResponseVO;
import com.gobiab.userservice.entity.User;
import com.gobiab.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("UserController:saveUser");
        return userService.saveUser(user);
    }

    @RequestMapping("/{id}")
    public ResponseVO getUserById(@PathVariable Long id){
        log.info("UserController:getUser");
            return userService.getUserById(id);
        }
    }

