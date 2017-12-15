package com.iu.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


//exception 처리 역할을 하는 controller라는 annotation
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String test(){
		return "";
	}
	
	@ExceptionHandler(RuntimeException.class)	//모든 예외를 처리하는 메서드
	public ModelAndView test2(){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "error");
		modelAndView.setViewName("common/result");
		
		return modelAndView;
	}
}
