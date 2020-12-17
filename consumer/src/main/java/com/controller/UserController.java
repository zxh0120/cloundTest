package com.controller;


import com.entity.UserEntity;
import com.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("getUsers")
    public void getUsers() {
        List<UserEntity> users = userService.findUserAll();
        for (UserEntity user : users) {
            System.out.println(user.getContent()+"--"+user.getPassword()+"--"+user.getUserName());
        }
    }

    @GetMapping("getDemo")
    public void getDemo() {
        String content = userService.findUserById();
        System.out.println(content);
    }
}
