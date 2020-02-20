package org.rent.cr.exception.handler;

import org.rent.cr.util.SecureUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustoAthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String error = "Login to generate correct JWT token";
        SecureUtils.writeResponseToHttpResponse(httpServletResponse, error, e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        httpServletResponse.getWriter().flush();
    }
}
