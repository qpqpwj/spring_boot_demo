package com.leon.demo.controller;

import com.leon.demo.domain.User;
import com.leon.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();

        user.setName(name);
        if(userRepository.save(user)){
            System.out.println("用户对象" + user.toString() + "保存成功");
        }
        return user;
    }
}
