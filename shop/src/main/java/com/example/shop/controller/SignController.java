package com.example.shop.controller;

import com.example.shop.annotation.PassToken;
import com.example.shop.common.Result;
import com.example.shop.controller.request.SignRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SignController {

    @PostMapping("/signIn")
    @PassToken(required=false)
    public Result in(@Validated @RequestBody SignRequest signRequest){

        return Result.success(signRequest);
    }
}
