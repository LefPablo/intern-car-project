package org.rent.cr.config;

import org.mockito.Mockito;
import org.rent.cr.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ReservationServiceTestConfiguration {

    @Bean
    @Primary
    public OrderService reservationService() {
        return Mockito.mock(OrderService.class);
    }
}
