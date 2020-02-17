package org.rent.cr.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.rent.cr.config.ReservationServiceTestConfiguration;
import org.rent.cr.dao.repo.ReservationRepository;
import org.rent.cr.service.ReservationService;
import org.rent.cr.util.SpringContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReservationServiceTestConfiguration.class)
public class ReservationServiceImplTest {

    @Test
    public void makeOrder() {

    }

    @Test
    public void setEmployeeFromAuthentication() {
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(user, pass);
////        Authentication auth = authManager.authenticate(authReq);
////        SecurityContext sc = SecurityContextHolder.getContext();
////        securityContext.setAuthentication(auth);
//        Authentication authentication = authenticationManager.authenticate(authRequest);
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        securityContext.setAuthentication(authentication);
//        ReservationService reservationService = new ReservationServiceImpl(SpringContext.getBean(ReservationRepository.class));
//        Mockito.when(reservationService.setEmployeeFromAuthentication()).then();
    }
}