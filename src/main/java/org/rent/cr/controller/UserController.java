package org.rent.cr.controller;

import org.rent.cr.entity.User;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserService> {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService, "User");
        this.userService = userService;
    }

    //Example of hidden of mapping
    @Override
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No message available")
    public void deleteAll() {
    }
}
