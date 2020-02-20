package org.rent.cr.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.rent.cr.dao.repo.EmployeeRepository;
import org.rent.cr.entity.Employee;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class SecureUtilsTest {

//    @TestConfiguration
//    static class SecureUtilsTestContextConfiguration {
//
//        @Bean
//        public SecureUtils secureUtils() {
//            return new SecureUtils();
//        }
//    }
//
//    @Autowired
//    private SecureUtils secureUtils;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee();
        employee.setEmail("superAdmin@gmail.com");

        Mockito.when(employeeRepository.findByEmail(employee.getEmail()))
                .thenReturn(employee);
    }

    @WithMockUser(username="superAdmin@gmail.com")
    @Test
    public void getEmployeeFromAuthentication() {
        String email = "superAdmin@gmail.com";
        Employee result = employeeRepository.findByEmail(SecureUtils.getUsernameFromAuthentication());
        assertEquals(email, result.getEmail());
    }

    @Test
    public void matchRoles() {

    }
}