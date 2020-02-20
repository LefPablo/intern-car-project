package org.rent.cr.exception.handler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ApiError {
    private String timestamp;
    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        statusCode = status.value();
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now().toString();
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        statusCode = status.value();
        this.message = message;
        errors = Arrays.asList(error);
        this.timestamp = LocalDateTime.now().toString();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
