package com.peregud.travelhistoryrest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class PaginationException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
