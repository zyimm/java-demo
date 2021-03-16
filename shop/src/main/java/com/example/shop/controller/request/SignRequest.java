package com.example.shop.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignRequest {

    @NotBlank(message = "用户账号不能为空")
    private String account;

    @NotBlank(message = "用户密码不能为空")
    private String pwd;
}
