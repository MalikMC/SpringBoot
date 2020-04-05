package com.machun.springbootexcption.controller.handler;

import com.machun.springbootexcption.vo.ResponseJsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author machun1
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *  //捕获全局未知异常
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    ResponseJsonData exceptionHandler(Exception ex, HttpServletRequest request){
        HashMap map= new HashMap(16);
        map.put("error_message",ex.getMessage());
        map.put("request_url",request.getRequestURI());
        map.put("request_cookies",request.getCookies());

        return  new ResponseJsonData( "100","未知异常",map);
    }

    /**
     * 捕获计算异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value =ArithmeticException.class)
    @ResponseBody
    Object arithmeticExceptionHandler(Exception ex, HttpServletRequest request){

        ModelAndView view =new ModelAndView();
        view.setViewName("error.html");
        view.addObject("msg",ex.getMessage());
        return  view;

    }

    /**
     * 捕获空指针异常
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    Object nullPointerExceptionHandler(Exception ex, HttpServletRequest request){

        ModelAndView view =new ModelAndView();
        view.setViewName("error.html");
        view.addObject("msg",ex.getMessage());
        return  view;

    }




}
