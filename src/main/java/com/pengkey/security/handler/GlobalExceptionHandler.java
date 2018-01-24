package com.pengkey.security.handler;


import com.pengkey.security.config.ErrorPageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static Logger logger = LoggerFactory.getLogger(ErrorPageConfig.class);


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandlerForView(Exception e){
        logger.info("------------exception start---------");
        logger.info(e.getMessage());
        logger.info("------------exception end----------");
        ModelAndView modal = new ModelAndView();
        modal.setViewName("/exception/exception.ftl");
        modal.addObject("messages", e.getMessage());
        return modal;
    }

/*    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map defaultExceptionHandlerForJSON(Exception e){
        logger.info("------------exception start---------");
        logger.info(e.getMessage());
        logger.info("------------exception end----------");
        Map<String,String> exceptionInfo= new HashMap<>();
        exceptionInfo.put("exceptionCode","404");
        exceptionInfo.put("message",e.getMessage());
        return exceptionInfo;
    }*/

}
