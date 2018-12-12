package com.ergou.jebrother.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 孙二狗
 * @Date: Created in 下午11:18 2018/7/25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e){

        Map<String, Object>  map = new HashMap<>();
        map.put("success", false);
        map.put("errMsg", e.getMessage());
        return map;
    }

}
