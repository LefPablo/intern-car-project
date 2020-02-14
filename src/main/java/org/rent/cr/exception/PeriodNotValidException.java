package org.rent.cr.exception;

import java.time.LocalDateTime;

public class PeriodNotValidException extends CustomValidationException {
    private LocalDateTime start;
    private LocalDateTime end;

    public PeriodNotValidException(LocalDateTime start, LocalDateTime end) {
        super("Period is not valid: start date [" + start + "] must be early then end date [" + end + "]");
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
