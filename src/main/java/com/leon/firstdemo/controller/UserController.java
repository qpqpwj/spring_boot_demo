package com.leon.firstdemo.controller;

import com.leon.firstdemo.domain.User;
import com.leon.firstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author jian.wang03@owitho.com
 * @create 2018-04-02 下午4:48
 * ${DESCRIPTION}
 **/
@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @PostMapping("/person/save")
    public User save(@RequestParam  String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.println("用户对象:" + user.toString());
        }
        return user;
    }
}
