package com.example.shop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.controller.request.SignRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {

    @PostMapping("/signIn")
    @PassToken(required=false)
    public Result in(@Validated @RequestBody SignRequest signRequest, BindingResult br){
        //判断参数是否校验失败，若校验失败，直接返回错误信息
        if (br.hasErrors()) {
            return Result.fail(br.getFieldError().getDefaultMessage());
        }

        return Result.success(signRequest);
    }
}
