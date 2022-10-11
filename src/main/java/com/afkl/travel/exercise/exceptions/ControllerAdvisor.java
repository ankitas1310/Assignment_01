package com.afkl.travel.exercise.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(final Throwable exception, final HttpServletRequest request) {
        LOG.error("Exception while processing the request:{}", exception);
        return exception.getMessage();
    }

    @ExceptionHandler(TravelException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleException(final TravelException exception, final HttpServletRequest request) {
        LOG.error("Exception while processing the request:{}", exception);
        return exception.getMessage();
    }
}
