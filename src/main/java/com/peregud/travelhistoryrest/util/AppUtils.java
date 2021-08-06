package com.peregud.travelhistoryrest.util;

import com.peregud.travelhistoryrest.exception.PaginationException;
import org.springframework.http.HttpStatus;

import static com.peregud.travelhistoryrest.util.AppConstants.MAX_PAGE_SIZE;

public class AppUtils {

    public static void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, "Page number cannot be less than zero.");
        }
        if (size < 0) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, "Size number cannot be less than zero.");
        }
        if (size > MAX_PAGE_SIZE) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, "Page size must not be greater than " + MAX_PAGE_SIZE);
        }
    }
}
