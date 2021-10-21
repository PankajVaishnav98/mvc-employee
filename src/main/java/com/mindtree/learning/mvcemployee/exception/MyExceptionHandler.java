package com.mindtree.learning.mvcemployee.exception;

import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public String resourceNotFoundHandling(ApplicationException exception, WebRequest request, Model model) {
		
		ErrorDetails error = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		model.addAttribute("error", error);
		
		return "errorDetails";
		
	}
}
