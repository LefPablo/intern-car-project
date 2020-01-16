package org.rent.cr.service.impl;

import org.rent.cr.entity.User;
import org.rent.cr.repo.UserRepository;
import org.rent.cr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends EntityServiceImpl<User, UserRepository> implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository, "User");
        this.userRepository = userRepository;
    }
}
