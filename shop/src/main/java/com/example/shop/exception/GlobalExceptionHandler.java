package com.example.shop.exception;

import com.example.shop.common.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public Result handleException(Exception e)  {
        String message = e.getMessage();
        if (message == null || message.isEmpty()) {
            message = "服务器出错";
        }
        return Result.fail(message, e.getStackTrace());
    }

    /**
     * handle 处理
     *
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return Result.fail(objectError.getDefaultMessage(), objectError.getArguments());
    }
}
