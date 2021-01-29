package com.example.shop.exception;

import com.example.shop.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handle 处理
     *
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e)  {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "服务器出错";
        }
        return Result.fail(message);
    }
}
