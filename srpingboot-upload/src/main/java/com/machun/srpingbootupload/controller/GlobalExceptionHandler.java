package com.machun.srpingbootupload.controller;

import com.machun.srpingbootupload.vo.ResponseJsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author machun1
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public ResponseJsonData uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) {
        System.out.println("upload fail" + e.getMessage());
        return new ResponseJsonData("-12", "Fail", e.getMessage() + e.getStackTrace());

    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseJsonData exceptionHandler(HttpServletRequest req, Exception e) {

        return new ResponseJsonData("-12", "Fail", e.getMessage() + e.getStackTrace());
    }
}
