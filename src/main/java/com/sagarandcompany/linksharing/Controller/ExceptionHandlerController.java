package com.sagarandcompany.linksharing.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ModelAndView internalServerError(Exception ex, WebRequest webRequest) {
        ModelAndView modelAndView = new ModelAndView("500");
        return modelAndView;
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ModelAndView internalServerError(RecordNotFoundException ex, WebRequest webRequest) {
        ModelAndView modelAndView = new ModelAndView("400");
        return modelAndView;
    }

}
