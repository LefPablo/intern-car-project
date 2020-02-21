package org.rent.cr.service.impl;

import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.rent.cr.entity.User;
import org.rent.cr.dao.repo.UserRepository;
import org.rent.cr.entity.enums.Role;
import org.rent.cr.exception.NoEntityException;
import org.rent.cr.service.UserService;
import org.rent.cr.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User, UserRepository> implements UserService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User update(User entity, User source) {
        Employee employee = employeeRepository.findByEmail(SecureUtils.getUsernameFromAuthentication());
        if (!SecureUtils.checkCredentials(Role.ROLE_SUPERADMIN, employee.getRoles(), entity.getEmployee().getRoles(), Role.ROLE_SUPERADMIN, Role.ROLE_ADMIN)) {
            throw new AccessDeniedException("For this action you must have role [" + Role.ROLE_SUPERADMIN + "]");
        }
        return super.update(entity, source);
    }
}
