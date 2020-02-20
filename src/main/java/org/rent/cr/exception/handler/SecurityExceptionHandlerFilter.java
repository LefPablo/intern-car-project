package org.rent.cr.exception.handler;

import org.rent.cr.exception.JwtAuthenticationException;
import org.rent.cr.util.SecureUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (RuntimeException e) {
            if (e instanceof JwtAuthenticationException) {
                handleJwtAuthentication((JwtAuthenticationException) e, httpServletResponse); //standart exception entry point resolve only when token is empty
            }
        }
    }

    public void handleJwtAuthentication(JwtAuthenticationException ex, HttpServletResponse httpServletResponse) throws IOException {
        String error = "Login to generate correct JWT token";
        SecureUtils.writeResponseToHttpResponse(httpServletResponse, error, ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        httpServletResponse.getWriter().flush();
    }
}
