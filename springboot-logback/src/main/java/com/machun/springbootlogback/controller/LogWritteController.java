package com.machun.springbootlogback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/5 15:59
 * @UpdateDate: 2020/4/5 15:59
 * @menu
 */
@Controller
@RequestMapping("log")
public class LogWritteController {
    public Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping("writte")
    public void  writteLog(){

          logger.debug("I am debug Log");
          logger.info("I am info Log");
          logger.error("I am error Log");
          logger.warn("I am warn Log");
          logger.trace("I am Trace Log");
    }

}
