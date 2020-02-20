package org.rent.cr.security;

import org.rent.cr.exception.handler.CustoAthenticationEntryPoint;
import org.rent.cr.exception.handler.CustomAccessDeniedHandler;
import org.rent.cr.exception.handler.SecurityExceptionHandlerFilter;
import org.rent.cr.security.jwt.JwtConfigurer;
import org.rent.cr.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenProvider jwtTokenProvider;

    private static final String LOGIN_ENDPOINT = "/guest/login";
    private static final String EMPLOYEE_ENDPOINT = "/employees/**";
    private static final String USER_ENDPOINT = "/users/**";
    private static final String BRAND_ENDPOINT = "/brands/**";
    private static final String CAR_ENDPOINT = "/cars/**";
    private static final String MODEL_ENDPOINT = "/models/**";
    private static final String COLOR_ENDPOINT = "/colors/**";
    private static final String OPTION_ENDPOINT = "/options/**";
    private static final String IMAGE_ENDPOINT = "/images/**";
    private static final String FINE_ENDPOINT = "/fines/**";
    private static final String EQUIPMENT_ENDPOINT = "/equipments/**";
    private static final String PERIOD_ENDPOINT = "/periods/**";
    private static final String PRICE_ENDPOINT = "/price/**";
    private static final String CHARACTERISTIC_ENDPOINT = "/characteristics/**";
    private static final String RESERVATION_ENDPOINT = "/reservations/**";
    private static final String ORDER_ENDPOINT = "/orders/**";

    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //GUEST
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers(HttpMethod.GET, BRAND_ENDPOINT, CAR_ENDPOINT,
                        MODEL_ENDPOINT, COLOR_ENDPOINT, OPTION_ENDPOINT,
                        IMAGE_ENDPOINT, FINE_ENDPOINT, EQUIPMENT_ENDPOINT,
                        PERIOD_ENDPOINT, PRICE_ENDPOINT, CHARACTERISTIC_ENDPOINT)
                .permitAll()
                .antMatchers(HttpMethod.POST, RESERVATION_ENDPOINT).permitAll()
                //EMPLOYEE
                .antMatchers(HttpMethod.GET, RESERVATION_ENDPOINT, ORDER_ENDPOINT).hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, ORDER_ENDPOINT).hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.PUT, RESERVATION_ENDPOINT, ORDER_ENDPOINT).hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.DELETE, ORDER_ENDPOINT).hasRole("EMPLOYEE")
                //ADMIN
                .antMatchers(EMPLOYEE_ENDPOINT).hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, RESERVATION_ENDPOINT).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,
                        USER_ENDPOINT, BRAND_ENDPOINT, CAR_ENDPOINT,
                        MODEL_ENDPOINT, COLOR_ENDPOINT, OPTION_ENDPOINT,
                        IMAGE_ENDPOINT, FINE_ENDPOINT, EQUIPMENT_ENDPOINT,
                        PERIOD_ENDPOINT, PRICE_ENDPOINT, CHARACTERISTIC_ENDPOINT)
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,
                        USER_ENDPOINT, BRAND_ENDPOINT, CAR_ENDPOINT,
                        MODEL_ENDPOINT, COLOR_ENDPOINT, OPTION_ENDPOINT,
                        IMAGE_ENDPOINT, FINE_ENDPOINT, EQUIPMENT_ENDPOINT,
                        PERIOD_ENDPOINT, PRICE_ENDPOINT, CHARACTERISTIC_ENDPOINT)
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,
                        USER_ENDPOINT, BRAND_ENDPOINT, CAR_ENDPOINT,
                        MODEL_ENDPOINT, COLOR_ENDPOINT, OPTION_ENDPOINT,
                        IMAGE_ENDPOINT, FINE_ENDPOINT, EQUIPMENT_ENDPOINT,
                        PERIOD_ENDPOINT, PRICE_ENDPOINT, CHARACTERISTIC_ENDPOINT)
                .hasRole("ADMIN")
                .and()
//                .exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint())
//                .and()
                .addFilterBefore(new SecurityExceptionHandlerFilter(), CorsFilter.class)
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).authenticationEntryPoint(new CustoAthenticationEntryPoint())
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
