package org.rent.cr.controller;

import org.rent.cr.entity.User;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends CrudController<User, UserService> {

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

    //Example of hidden of mapping
    @Override
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No message available")
    public Object deleteAll() {
        return null;
    }
}
