package com.peregud.travelhistoryrest.util;

import com.peregud.travelhistoryrest.exception.PaginationException;
import org.springframework.http.HttpStatus;

import static com.peregud.travelhistoryrest.util.AppConstants.*;

public class PageUtil {

    public static void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, ERROR_NEGATIVE_PAGE);
        }
        if (size < 0) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, ERROR_NEGATIVE_SIZE);
        }
        if (size > MAX_PAGE_SIZE) {
            throw new PaginationException(HttpStatus.BAD_REQUEST, ERROR_OVERSIZE + MAX_PAGE_SIZE);
        }
    }
}
