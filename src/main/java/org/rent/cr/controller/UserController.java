package org.rent.cr.controller;

import org.rent.cr.entity.User;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends EntityController<User, UserService> {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService, "User");
        this.userService = userService;
    }

    @Override
    @DeleteMapping
    @RequestMapping("")
    public void deleteAll() {
        super.deleteAll();
    }
}
