package com.hibicode.beerstore.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @Autowired
    private ApiExceptionHandler apiExceptionHandler;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerInternalServerError(Exception exception, Locale locale) {
        LOG.error("Error not expected", exception);
        final String errorCode = "error-1";
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorResponse errorResponse = ErrorResponse.of(status, apiExceptionHandler.toApiError(errorCode, locale));
        return ResponseEntity.status(status).body(errorResponse);
    }
}
