package org.rent.cr.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.rent.cr.entity.enums.Role;
import org.rent.cr.exception.handler.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@UtilityClass
public class SecureUtils {

    public String getUsernameFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

    public boolean matchRoles(List<Role> sourceRoles, Role requiredRole) {
        if (sourceRoles != null) {
            return sourceRoles.contains(requiredRole);
        } else {
            return false;
        }
    }

    public void writeResponseToHttpResponse(HttpServletResponse httpServletResponse, String error, String localizedMessage, HttpStatus status) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ApiError apiError = new ApiError(
                status, localizedMessage, error);
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
        String result = mapper.writeValueAsString(responseEntity);
        httpServletResponse.setContentType("application/json");
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.print(result);
    }

    public boolean checkCredentials(Role necessaryRole, List<Role> registered, List<Role> sourceRoles, Role... protectedRoles) {
        for (Role role : protectedRoles) {
            if (sourceRoles.contains(role)) {
                if (!SecureUtils.matchRoles(registered, necessaryRole)) {
                    return false;
                }
            }
        }
        return true;
    }
}
