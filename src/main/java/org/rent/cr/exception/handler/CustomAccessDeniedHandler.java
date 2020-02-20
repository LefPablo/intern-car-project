package org.rent.cr.exception.handler;

import org.rent.cr.util.SecureUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        String error = "Not correct credentials";
        SecureUtils.writeResponseToHttpResponse(httpServletResponse, error, e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        httpServletResponse.getWriter().flush();
    }
}
