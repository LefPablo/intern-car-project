package org.rent.cr.service.impl;

import org.rent.cr.entity.User;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.EntityService;

import java.util.List;

public class UserServiceImpl implements EntityService<User> {
    @Override
    public User findById(int id) throws NoEntityException {
        return null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
